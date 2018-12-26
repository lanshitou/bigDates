package com.tomsung.agdc.service;

import com.tomsung.agdc.vo.CountVo;
import com.tomsung.agdc.vo.MapVo;
import com.tomsung.agdc.vo.OverviewMapVo;
import com.tomsung.agdc.vo.RankVo;

import java.util.Date;
import java.util.List;

public interface IHomeService {

    List<CountVo> getCountList();

    List<RankVo> getRateListByCrop();

    List<RankVo> getRateListByCity();

    List<RankVo> getSuggestionSales(Integer id);

    List<Object> getFarmRank();

    List<OverviewMapVo> getFarmSpread();

    List<MapVo> getContractUserCountLists(Integer type);

    List<MapVo> getContractUserCountList(Date beginTime, Date endTime);
}
