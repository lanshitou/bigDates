package com.tomsung.agdc.service;

import com.tomsung.agdc.vo.MeteorologicalDataVo;
import com.tomsung.agdc.vo.NowMeteorologicalDataVo;

import java.util.List;

/**
 * Created by Lvpin on 2018/9/25.
 */
public interface IMeteorologicalService {
    List<MeteorologicalDataVo> getMeteorologicalData(Integer blockId, String time, Integer type);

    List<NowMeteorologicalDataVo> getNowMeteorologicalData(Integer blockId);
}
