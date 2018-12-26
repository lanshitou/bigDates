package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.mapper.AirHumidityMapper;
import com.tomsung.agdc.service.IMeteorologicalService;
import com.tomsung.agdc.vo.MeteorologicalDataVo;
import com.tomsung.agdc.vo.NowMeteorologicalDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lvpin on 2018/9/25.
 */
@Service
public class MeteorologicalServiceImpl implements IMeteorologicalService {
    @Autowired
    AirHumidityMapper airHumidityMapper;

    @Override
    public List<MeteorologicalDataVo> getMeteorologicalData(Integer blockId, String time, Integer type) {
        List<MeteorologicalDataVo> meteorologicalDataVo = new ArrayList<>();
        if (type == 0) {
            meteorologicalDataVo = airHumidityMapper.selectLightData(blockId, time);
        }
        if (type == 1) {
            meteorologicalDataVo = airHumidityMapper.selectCo2Data(blockId, time);
        }
        if (type == 2) {
            meteorologicalDataVo = airHumidityMapper.selectAirTemperatureData(blockId, time);
        }
        if (type == 3) {
            meteorologicalDataVo = airHumidityMapper.selectAirHumidityData(blockId, time);
        }
        if (type == 4) {
            meteorologicalDataVo = airHumidityMapper.selectSoilTemperatureData(blockId, time);
        }
        if (type == 5) {
            meteorologicalDataVo = airHumidityMapper.selectSoilMostureData(blockId, time);
        }
        return meteorologicalDataVo;
    }

    @Override
    public List<NowMeteorologicalDataVo> getNowMeteorologicalData(Integer blockId) {
        List<NowMeteorologicalDataVo> nowMeteorologicalDataVo = new ArrayList<>();

        NowMeteorologicalDataVo lightData = new NowMeteorologicalDataVo();
        lightData.setNum(0);
        lightData.setValue(airHumidityMapper.selectLightDataByMaxDate(blockId));

        NowMeteorologicalDataVo co2Data = new NowMeteorologicalDataVo();
        co2Data.setNum(1);
        co2Data.setValue(airHumidityMapper.selectCo2DataByMaxDate(blockId));

        NowMeteorologicalDataVo airTemperatureData = new NowMeteorologicalDataVo();
        airTemperatureData.setNum(2);
        airTemperatureData.setValue(airHumidityMapper.selectAirTemperatureDataByMaxDate(blockId));

        NowMeteorologicalDataVo airHumidityData = new NowMeteorologicalDataVo();
        airHumidityData.setNum(3);
        airHumidityData.setValue(airHumidityMapper.selectAirTemperatureDataByMaxDate(blockId));

        NowMeteorologicalDataVo soilTemperatureData = new NowMeteorologicalDataVo();
        soilTemperatureData.setNum(4);
        soilTemperatureData.setValue(airHumidityMapper.selectSoilTemperatureDataByMaxDate(blockId));

        NowMeteorologicalDataVo soilHumidityData = new NowMeteorologicalDataVo();
        soilHumidityData.setNum(5);
        soilHumidityData.setValue(airHumidityMapper.selectSoilMostureDataByMaxDate(blockId));
        nowMeteorologicalDataVo.add(lightData);
        nowMeteorologicalDataVo.add(co2Data);
        nowMeteorologicalDataVo.add(airTemperatureData);
        nowMeteorologicalDataVo.add(airHumidityData);
        nowMeteorologicalDataVo.add(soilTemperatureData);
        nowMeteorologicalDataVo.add(soilHumidityData);
        return nowMeteorologicalDataVo;
    }
}
