package com.tomsung.agdc.service;

import com.tomsung.agdc.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    List<CountVo> getCountList();

    //区域订单数排名
    List<RankVo> getOrderGroupByDistrict(Date beginTime,Date endTime);
    //化肥订单数
    List<RankVo> getOrderGroupByProduct();
    //时间段订单数
    List<RankVo> getOrderCount(Date beginTime,Date endTime);
    //区域订单
    List <MapVo>getOrderDistrict();
    //厂商订单量
    List <CompanyVo> getOrderCompany();
    //订单航线
    List<List<FlightVo>> getOrderFlight();
}
