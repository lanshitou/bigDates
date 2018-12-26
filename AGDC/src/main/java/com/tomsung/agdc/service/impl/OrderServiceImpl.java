package com.tomsung.agdc.service.impl;


import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.domain.Order;
import com.tomsung.agdc.domain.Production;
import com.tomsung.agdc.mapper.*;
import com.tomsung.agdc.service.IOrderService;
import com.tomsung.agdc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    SuggestionMapper suggestionMapper;
    @Autowired
    ProductionMapper productionMapper;
    @Autowired
    PickupPointMapper pickupPointMapper;
    @Autowired
    ProductCompanyMapper productCompanyMapper;

    @Override
    public List<CountVo> getCountList() {
        List<CountVo> vos = new ArrayList<CountVo>();
        //获取当前时间的前一个月
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();

        //交易总金额
        CountVo vos1 = new CountVo();
        vos1.id = 1;
        vos1.count = orderMapper.selectMountOfMoney(null);
        vos1.monthCount = orderMapper.selectMountOfMoney(date);
        vos.add(vos1);
        //种植方案数
        CountVo vos2 = new CountVo();
        vos2.id = 2;
        vos2.count = suggestionMapper.selectSuggestionCount(null);
        vos2.monthCount = suggestionMapper.selectSuggestionCount(date);
        vos.add(vos2);
        //商品总数
        CountVo vos3 = new CountVo();
        vos3.id = 3;
        vos3.count = productionMapper.selectProductionCount(null);
        vos3.monthCount = productionMapper.selectProductionCount(date);
        vos.add(vos3);
        //订单总数
        CountVo vos4 = new CountVo();
        vos4.id = 4;
        vos4.count = orderMapper.selectOrderCount(null);
        vos4.monthCount = orderMapper.selectOrderCount(date);
        vos.add(vos4);
        //出售化肥总质量
        CountVo vos5 = new CountVo();
        vos5.id = 5;
        vos5.count = orderMapper.selectMountOfWeight(null);
        vos5.monthCount = orderMapper.selectMountOfWeight(date);
        vos.add(vos5);
        //自提点数量
        CountVo vos6 = new CountVo();
        vos6.id = 6;
        vos6.count = pickupPointMapper.selectPickupCount(null);
        vos6.monthCount = pickupPointMapper.selectPickupCount(date);
        vos.add(vos6);
        //站长服务人员(TODO)
        CountVo vos7 = new CountVo();
        vos7.id = 7;
        vos7.count = 15;
        vos7.monthCount = 3;
        vos.add(vos7);
        //肥料销售区域
        CountVo vos8 = new CountVo();
        vos8.id = 8;
        vos8.count = orderMapper.selectDistrictCount();
        vos8.monthCount = orderMapper.selectMonthDistrictCount(date);
        vos.add(vos8);
        return vos;
    }

    @Override
    public List<RankVo> getOrderGroupByDistrict(Date beginTime, Date endTime) {
        List<RankVo> vos = new ArrayList<RankVo>();
        List<Order> orders = orderMapper.selectOrderGroupByDistrict(beginTime, endTime);
        for (Order o : orders) {
            RankVo vo = new RankVo();
            vo.setName(o.getDistrictName());
            vo.setValue(o.getOrderCount());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<RankVo> getOrderGroupByProduct() {
        List<RankVo> vos = new ArrayList<RankVo>();
        List<Production> productions = productionMapper.selectProduct();
        for (Production p : productions) {
            RankVo vo = new RankVo();
            //商品分类名称
            vo.setName(p.getCategoryName());
            //计算各类商品订单数
            int sum = 0;
            String[] arr = p.getProductString().split(","); //每个种类中的商品数组
            for (int i = 0; i < arr.length; i++) {
                Integer i1 = productionMapper.selectOrderCountGroupByProduct(Integer.parseInt(arr[i]));
                sum = sum + i1;
            }
            vo.setValue(sum);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<RankVo> getOrderCount(Date beginTime, Date endTime) {
        //传进来时间段,则按时间段,没有的话默认近半年
        if (beginTime != null || endTime != null) {
            //计算时间间隔
            long time1 = beginTime.getTime();
            long time2 = endTime.getTime();
            long day = (time2 - time1) / (1000 * 3600 * 24);
            List<RankVo> countList = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            int count = 0;
            //时间间隔小于30天,每2天一个点
            if (day < Constants.ONE_MONTH) {
                while (count <= day) {
                    count += 2;
                    RankVo vo = new RankVo();
                    vo.setName((calendar.get(Calendar.MONTH) + 1) + Constants.MONTH + calendar.get(Calendar.DAY_OF_MONTH) + Constants.DAY);
                    vo.setValue(orderMapper.selectOrderCountByTime(calendar.getTime()));
                    countList.add(vo);
                    calendar.add(Calendar.DAY_OF_MONTH, -2);
                }
                //时间间隔小于90天,每7天一个点
            } else if (day < Constants.THREE_MONTH) {
                while (count <= day) {
                    count += 7;
                    RankVo vo = new RankVo();
                    vo.setName((calendar.get(Calendar.MONTH) + 1) + Constants.MONTH + calendar.get(Calendar.DAY_OF_MONTH) + Constants.DAY);
                    vo.setValue(orderMapper.selectOrderCountByTime(calendar.getTime()));
                    countList.add(vo);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                }
                //时间间隔小于一年半,每个月一个点
            } else if (day < Constants.ONE_HALF_YEAR) {
                while (count <= day) {
                    count += 30;
                    RankVo vo = new RankVo();
                    vo.setName(calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH);
                    vo.setValue(orderMapper.selectOrderCountByTime(calendar.getTime()));
                    countList.add(vo);
                    calendar.add(Calendar.MONTH, -1);
                }
            } else {
                //大于一年的每年一个点
                while (count <= day) {
                    count += 365;
                    RankVo vo = new RankVo();
                    vo.setName(calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH);
                    vo.setValue(orderMapper.selectOrderCountByTime(calendar.getTime()));
                    countList.add(vo);
                    calendar.add(Calendar.YEAR, -1);
                }
            }
            Collections.reverse(countList);
            return countList;
        } else {
            List<RankVo> countList = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            for (int i = 1; i <= Constants.FORMONTH; i++) {
                RankVo vo = new RankVo();
                vo.setName(calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH);
                vo.setValue(orderMapper.selectOrderCountByTime(calendar.getTime()));
                countList.add(vo);
                calendar.add(Calendar.MONTH, -1);
            }
            Collections.reverse(countList);
            return countList;
        }
    }

    @Override
    public List<MapVo> getOrderDistrict() {
        List<MapVo> vos = new ArrayList<MapVo>();
        List<Order> orders = orderMapper.selectDistrictOrderInfo();
        for (Order o : orders) {
            MapVo vo = new MapVo();
            vo.name = o.getProvinceName();
            vo.value = new LinkedList<>();
            vo.value.add(o.getOrderCount());
            vo.value.add(o.getSumPayment());
            vo.value.add(o.getSumWeight());
            vo.value.add(o.getSugCount());
            vo.value.add(orders.indexOf(o) + 1);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<CompanyVo> getOrderCompany() {
        List<CompanyVo> vos = new ArrayList<CompanyVo>();
        //厂商集合
        List<String> list1 = productCompanyMapper.selectCompany();
        List<Integer> list2 = productCompanyMapper.selectCompanyId();
        CompanyVo vo = new CompanyVo();
        vo.name = list1;
        //X坐标时间集合
        vo.x = new ArrayList<String>();
        vo.y = new ArrayList<List<Integer>>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < Constants.FORMONTH; i++) {
            String a = calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH;
            vo.x.add(a);
            calendar.add(Calendar.MONTH, -1);
        }
        Collections.reverse(vo.x);
        //Y坐标数量集合
        Integer count;
        for (Integer l : list2) {
            List<Integer> list3 = new ArrayList<>();
            Calendar calendar1 = Calendar.getInstance();
            for (int i = 0; i < Constants.FORMONTH; i++) {
                count = orderMapper.selectCountByCompanyAndTime(String.valueOf(l), calendar1.getTime());
                list3.add(count);
                calendar1.add(Calendar.MONTH, -1);
            }
            Collections.reverse(list3);
            vo.y.add(list3);
        }
        vos.add(vo);
        return vos;
    }

//    @Override
//    public List<FlightVo> getOrderFlight() {
//        List<FlightVo> vos=new ArrayList<>();
//        List<String> startlist=new ArrayList<String> ();
//        List<String>  endlist=new ArrayList<String> ();
//        FlightVo vo=new FlightVo();
//        //起点
//        List<Integer> list1 = productCompanyMapper.selectCompanyId();
//        List<String> list2 = productCompanyMapper.selectCompanyCity();
//        for (Integer l:list1){
//            int count=orderMapper.selectCountByCompany(l);
//            String cityname=list2.get(list1.indexOf(l));
//            for (int i=0;i<count;i++){
//                startlist.add(cityname);
//            }
//        }
//        vo.start=startlist;
//        //终点
//        for (Integer l:list1) {
//            endlist.addAll(orderMapper.selectCityByCompany(String.valueOf(l)));
//        }
//        vo.end=endlist;
//        vos.add(vo);
//        return vos;
//    }

    @Override
    public List<List<FlightVo>> getOrderFlight() {
        List<List<FlightVo>> list = new ArrayList<>();
        List<String> endlist = new ArrayList<String>();
        List<Integer> list1 = productCompanyMapper.selectCompanyId();
        List<String> list2 = productCompanyMapper.selectCompanyCity();
        for (Integer l : list1) {
            List<FlightVo> vos = new ArrayList<>();
            FlightVo vo = new FlightVo();
            vo.name = list2.get(list1.indexOf(l));
            vos.add(vo);
            endlist = orderMapper.selectCityByCompany(String.valueOf(l));
            for (String e : endlist) {
                FlightVo vo1 = new FlightVo();
                vo1.name = e;
                vos.add(vo1);
            }
            list.add(vos);
        }
        return list;
    }
}
