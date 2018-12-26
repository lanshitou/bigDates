package com.tomsung.agdc.service.impl;

import com.google.common.base.Joiner;
import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.domain.Question;
import com.tomsung.agdc.domain.Suggestion;
import com.tomsung.agdc.mapper.*;
import com.tomsung.agdc.service.IHomeService;
import com.tomsung.agdc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ExpertMapper expertMapper;
    @Autowired
    OperateLogMapper operateLogMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    SuggestionMapper suggestionMapper;
    @Autowired
    BlockMapper blockMapper;
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<CountVo> getCountList() {

        List<CountVo> vos = new ArrayList<CountVo>();
        //获取当前时间的前一个月
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();

        //总覆盖面积
        CountVo vos1 = new CountVo();
        vos1.id = 1;
        vos1.count = blockMapper.selectBlockAreaTotal(null);
        vos1.monthCount = blockMapper.selectBlockAreaTotal(date);
        vos.add(vos1);
        //交易总金额
        CountVo vos2 = new CountVo();
        vos2.id = 2;
        vos2.count = orderMapper.selectMountOfMoney(null);
        vos2.monthCount = orderMapper.selectMoneyAvg();
        vos.add(vos2);
        //总设备数
        CountVo vos3 = new CountVo();
        vos3.id = 3;
        vos3.count = deviceMapper.selectDeviceCount(null);
        vos3.monthCount = deviceMapper.selectDeviceCount(date);
        vos.add(vos3);
        //覆盖大棚总数
        CountVo vos4 = new CountVo();
        vos4.id = 4;
        vos4.count = blockMapper.selectBlockCount(null);
        vos4.monthCount = blockMapper.selectBlockCount(date);
        vos.add(vos4);
        //注册用户总数
        CountVo vos5 = new CountVo();
        vos5.id = 5;
        vos5.count = userMapper.selectUserCount(null);
        vos5.monthCount = userMapper.selectUserCount(date);
        vos.add(vos5);
        //活跃用户总数
        CountVo vos6 = new CountVo();
        vos6.id = 6;
        vos6.count = operateLogMapper.selectActivityCount(null);
        vos6.monthCount = operateLogMapper.selectActivityCount(date);
        vos.add(vos6);
        //专家总数
        CountVo vo7 = new CountVo();
        vo7.id = 7;
        vo7.count = expertMapper.selectExpertCount(null);
        vo7.monthCount = expertMapper.selectExpertCount(date);
        vos.add(vo7);
        //线上问题解答率
        CountVo vo8 = new CountVo();
        vo8.id = 8;
        int temp = (int) (((double) questionMapper.selectSolvedCount(null) / (double) questionMapper.selectQuestionCount(null)) * 100);
        vo8.count = temp + "%";
        vo8.monthCount = temp - (int) (((double) questionMapper.selectSolvedCount(date) / (double) questionMapper.selectQuestionCount(date)) * 100) + "%";
        vos.add(vo8);
        return vos;
    }

    @Override
    public List<RankVo> getRateListByCrop() {
        List<RankVo> vos = new ArrayList<>();
        List<Question> questions = questionMapper.selectSolvedByCrop();
        for (Question q : questions) {
            RankVo vo = new RankVo();
            vo.setName(q.getCropName());
            vo.setValue((int) (((double) q.getSolvedCount() / (double) q.getQuestionCount()) * 100));
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<RankVo> getRateListByCity() {
        List<RankVo> vos = new ArrayList<>();
        List<Question> questions = questionMapper.selectSolvedByCity();
        for (Question q : questions) {
            RankVo vo = new RankVo();
            vo.setName(q.getCityName());
            vo.setValue((int) (((double) q.getSolvedCount() / (double) q.getQuestionCount()) * 100));
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<RankVo> getSuggestionSales(Integer id) {
        List<RankVo> vos = new ArrayList<>();
        if (id == 1) {
            List<Suggestion> suggestions = suggestionMapper.selectSales();
            double sum = suggestionMapper.selectSum();
            double fiveSum = 0;
            for (Suggestion s : suggestions) {
                RankVo vo = new RankVo();
                vo.setName(s.getName());
                vo.setValue(s.getSales());
                fiveSum += s.getSales();
                vos.add(vo);
            }
            RankVo vo = new RankVo();
            vo.setName("其他");
            vo.setValue(new DecimalFormat("#.00").format(sum - fiveSum));
            vos.add(vo);
        } else {
            List<Suggestion> suggestions = suggestionMapper.selectSales();
            double sum = suggestionMapper.selectPrepaidSum();
            double fiveSum = 0;
            for (Suggestion s : suggestions) {
                RankVo vo = new RankVo();
                vo.setName(s.getName());
                vo.setValue(s.getPrepaid());
                fiveSum += s.getPrepaid();
                vos.add(vo);
            }
            RankVo vo = new RankVo();
            vo.setName("其他");
            vo.setValue(new DecimalFormat("#.00").format(sum - fiveSum));
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<Object> getFarmRank() {
        List<Object> resData = new ArrayList<>();
        List<AreaSizeRankVo> areaSizeRankVos = blockMapper.selectFarmlandArea();
        for (AreaSizeRankVo areaSizeRankVo : areaSizeRankVos) {
            areaSizeRankVo.setCropCount(blockMapper.cropCount(areaSizeRankVo.getAreaCode()));
        }
        Integer allCropCount = blockMapper.selectAllCropCount();
        Integer allBlockCount = blockMapper.selectAllBlockCount();
        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("allCropCount", allCropCount);
        dataMap.put("allBlockCount", allBlockCount);
        resData.add(areaSizeRankVos);
        resData.add(dataMap);
        return resData;
    }

    @Override
    public List<OverviewMapVo> getFarmSpread() {
        List<OverviewMapVo> vos = new ArrayList<>();
        List<OverviewMapVo.Inner> inners = blockMapper.selectOverviewMap();
        for (OverviewMapVo.Inner inner : inners) {
            OverviewMapVo vo = new OverviewMapVo();
            vo.setName(inner.getName());
            List<Object> list = new ArrayList<>();
            list.add(inner.getAddressX());
            list.add(inner.getAddressY());
            list.add(inner.getBlockArea());
            list.add(inner.getCount());
            List<String> strings = blockMapper.selectCropNames(inner.getAreaCode());
            String join = Joiner.on(",").skipNulls().join(strings);
            list.add(join);
            vo.setValue(list);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<MapVo> getContractUserCountList(Date beginTime, Date endTime) {
        //传进来时间段,则按时间段,没有的话默认近半年
        if (beginTime != null || endTime != null) {
            //计算时间间隔
            long time1 = beginTime.getTime();
            long time2 = endTime.getTime();
            long day = (time2 - time1) / (1000 * 3600 * 24);
            List<MapVo> countList = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            int count = 0;
            //时间间隔小于30天,每2天一个点
            if (day < Constants.ONE_MONTH) {
                while (count <= day) {
                    count += 2;
                    MapVo vo = new MapVo();
                    vo.name = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH);
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectUserCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.DAY_OF_MONTH, -2);
                }
                //时间间隔小于90天,每7天一个点
            } else if (day < Constants.THREE_MONTH) {
                while (count <= day) {
                    count += 7;
                    MapVo vo = new MapVo();
                    vo.name = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH);
                    List<Integer> list = new ArrayList<>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectUserCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                }
                //时间间隔小于一年半,每个月一个点
            } else if (day < Constants.ONE_HALF_YEAR) {
                while (count <= day) {
                    count += 30;
                    MapVo vo = new MapVo();
                    vo.name = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1);
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectUserCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.MONTH, -1);
                }
            } else {
                //大于一年的每年一个点
                while (count <= day) {
                    count += 365;
                    MapVo vo = new MapVo();
                    vo.name = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1);
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectUserCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.YEAR, -1);
                }
            }
            Collections.reverse(countList);
            return countList;
        } else {
            List<MapVo> countList = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            for (int i = 1; i <= Constants.FORMONTH; i++) {
                MapVo vo = new MapVo();
                vo.name = calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH) + 1);
                List<Integer> list = new ArrayList<Integer>();
                list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                list.add(userMapper.selectUserCountByTime(calendar.getTime()));
                vo.value = list;
                countList.add(vo);
                calendar.add(Calendar.MONTH, -1);
            }
            Collections.reverse(countList);
            return countList;
        }
    }

    @Override
    public List<MapVo> getContractUserCountLists(Integer type) {
        List<MapVo> timeInterval = HomeServiceImpl.getTimeInterval(type);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (MapVo mapVo : timeInterval) {
            List<Integer> list = new ArrayList<>();
            try {
                list.add(userMapper.selectContractCountByTime(dateFormat.parse(mapVo.name)));
                list.add(userMapper.selectUserCountByTime(dateFormat.parse(mapVo.name)));
                SimpleDateFormat sdf = null;
                if (type == 0) {
                    sdf = new SimpleDateFormat("yyyy/MM/dd");
                } else {
                    sdf = new SimpleDateFormat("yyyy/MM");
                }
                mapVo.name = sdf.format(dateFormat.parse(mapVo.name));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            mapVo.value = list;
        }
        Collections.reverse(timeInterval);
        return timeInterval;
    }

    public static List<MapVo> getTimeInterval(Integer type) {
        List<MapVo> objects = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        if (type == 0) {
            calendar.setTime(new Date());
            for (int i = 1; i <= 30 / 3 + 1; i++) {
                MapVo mapVo = new MapVo();
                mapVo.name = dateFormat.format(calendar.getTime());
                calendar.add(Calendar.DAY_OF_MONTH, -3);
                objects.add(mapVo);
            }
        }
        if (type == 1) {
            for (int i = 0; i <= 2; i++) {
                MapVo mapVo = new MapVo();
                mapVo.name = dateFormat.format(calendar.getTime());
                calendar.add(Calendar.MONTH, -1);
                objects.add(mapVo);
            }
        }
        if (type == 2) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            calendar.set(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH), 1);
            for (int i = 0; i <= instance.get(Calendar.MONTH); i++) {
                MapVo mapVo = new MapVo();
                mapVo.name = dateFormat.format(calendar.getTime());
                calendar.add(Calendar.MONTH, -1);
                objects.add(mapVo);
            }
        }
        if (type == 3) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            calendar.set(instance.get(Calendar.YEAR) - 1, 11, 1);
            for (int i = 0; i <= 11; i++) {
                MapVo mapVo = new MapVo();
                mapVo.name = dateFormat.format(calendar.getTime());
                calendar.add(Calendar.MONTH, -1);
                objects.add(mapVo);
            }
        }
        return objects;
    }
}
