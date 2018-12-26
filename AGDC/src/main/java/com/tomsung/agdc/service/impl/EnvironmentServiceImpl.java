package com.tomsung.agdc.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.domain.BeamStrength;
import com.tomsung.agdc.domain.Co2;
import com.tomsung.agdc.domain.Humidity;
import com.tomsung.agdc.domain.Temperature;
import com.tomsung.agdc.mapper.BeamStrengthMapper;
import com.tomsung.agdc.mapper.Co2Mapper;
import com.tomsung.agdc.mapper.HumidityMapper;
import com.tomsung.agdc.mapper.TemperatureMapper;
import com.tomsung.agdc.service.IEnvironmentService;
import com.tomsung.agdc.vo.EnvironmentVo;

@Service
public class EnvironmentServiceImpl implements IEnvironmentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TemperatureMapper temperatureMapper;
    private HumidityMapper humidityMapper;
    private Co2Mapper co2Mapper;
    private BeamStrengthMapper beamStrengthMapper;

    @Autowired
    public EnvironmentServiceImpl(
            TemperatureMapper temperatureMapper,
            HumidityMapper humidityMapper,
            Co2Mapper co2Mapper,
            BeamStrengthMapper beamStrengthMapper
    ) {
        this.temperatureMapper = temperatureMapper;
        this.humidityMapper = humidityMapper;
        this.co2Mapper = co2Mapper;
        this.beamStrengthMapper = beamStrengthMapper;
    }

    @Override
    public EnvironmentVo getTemperatureList(Integer farmlandId, Date beginTime, Date endTime, int devType) {
        try {
            List<Temperature> temperatures = temperatureMapper.selectTemperature(farmlandId, beginTime, endTime, devType);
            List<ResData> datas = new ArrayList<ResData>();
            if (CollectionUtils.isNotEmpty(temperatures)) {
                for (Temperature temp : temperatures) {
                    ResData data = new ResData();
                    data.DATA = temp.getTempdata();
                    data.TIME = temp.getTime();
                    datas.add(data);
                }
                EnvironmentVo environmentVo = this.processData(beginTime, endTime, datas);
                return this.processData(beginTime, endTime, datas);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public EnvironmentVo getHumidityList(Integer farmlandId, Date beginTime, Date endTime, int devType) {
        try {
            List<Humidity> humiditys = humidityMapper.selectHimidity(farmlandId, beginTime, endTime, devType);
            List<ResData> datas = new ArrayList<ResData>();
            if (CollectionUtils.isNotEmpty(humiditys)) {

                for (Humidity humidity : humiditys) {
                    ResData data = new ResData();
                    data.DATA = humidity.getHumiditydata();
                    data.TIME = humidity.getTime();
                    datas.add(data);
                }
                return this.processData(beginTime, endTime, datas);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public EnvironmentVo getCO2List(Integer farmlandId, Date beginTime, Date endTime) {
        try {
            List<Co2> co2s = co2Mapper.selectCo2(farmlandId, beginTime, endTime);
            List<ResData> datas = new ArrayList<ResData>();
            if (CollectionUtils.isNotEmpty(co2s)) {
                for (Co2 co2 : co2s) {
                    ResData data = new ResData();
                    data.DATA = co2.getCo2data();
                    data.TIME = co2.getTime();
                    datas.add(data);
                }
                return this.processData(beginTime, endTime, datas);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public EnvironmentVo getBeamstrengthList(Integer farmlandId, Date beginTime, Date endTime) {
        try {
            List<BeamStrength> beamstrengths = beamStrengthMapper.selectBeamstrength(farmlandId, beginTime, endTime);
            List<ResData> datas = new ArrayList<ResData>();
            if (CollectionUtils.isNotEmpty(beamstrengths)) {
                for (BeamStrength beamStrength : beamstrengths) {
                    ResData data = new ResData();
                    data.DATA = beamStrength.getBeamdata();
                    data.TIME = beamStrength.getTime();
                    datas.add(data);
                }
                return this.processData(beginTime, endTime, datas);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public boolean addTemperature(Temperature tem) {
        boolean result;
        if (temperatureMapper.insert(tem) == 1) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private EnvironmentVo processData(Date beginTime, Date endTime, List<ResData> datas) {
        EnvironmentVo res = new EnvironmentVo();
        Calendar cal = Calendar.getInstance();
        Map<String, List<BigDecimal>> day2Data = new LinkedHashMap<String, List<BigDecimal>>();
        long between = endTime.getTime() - beginTime.getTime();
        if (between > (24 * 3600000)) {
            for (ResData data : datas) {
                cal.setTime(data.TIME);
                Integer day = cal.get(Calendar.DATE);
                Integer month = cal.get(Calendar.MONTH) + 1;
                Integer year = cal.get(Calendar.YEAR);
                String key = String.valueOf(year) + "," + String.valueOf(month) + "," + String.valueOf(day);
                List<BigDecimal> ds = day2Data.get(key);
                if (ds == null) {
                    ds = new ArrayList<BigDecimal>();
                    ds.add(data.DATA);
                    day2Data.put(key, ds);
                } else {
                    ds.add(data.DATA);
                }
            }

            for (Map.Entry<String, List<BigDecimal>> entry : day2Data.entrySet()) {
                String yearMonthDays = entry.getKey();
                String yearMonthDay[] = yearMonthDays.split(",");
                res.TIME.add(yearMonthDay[0] + Constants.YEAR + yearMonthDay[1] + Constants.MONTH + yearMonthDay[2] + Constants.DAY);
                res.MAX.add(Collections.max(entry.getValue()));
                res.MIN.add(Collections.min(entry.getValue()));
                res.AVG.add(getAvg(entry.getValue()));
            }
        } else {
            for (ResData data : datas) {
                cal.setTime(data.TIME);
                String key = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
                List<BigDecimal> ds = day2Data.get(key);
                if (ds == null) {
                    ds = new ArrayList<BigDecimal>();
                    ds.add(data.DATA);
                    day2Data.put(key, ds);

                } else {
                    ds.add(data.DATA);
                }
            }
            for (Map.Entry<String, List<BigDecimal>> entry : day2Data.entrySet()) {
                res.TIME.add(cal.get(Calendar.HOUR_OF_DAY) + Constants.HOUR);
                res.MAX.add(Collections.max(entry.getValue()));
                res.MIN.add(Collections.min(entry.getValue()));
                res.AVG.add(getAvg(entry.getValue()));
            }
        }

        return res;
    }

    private BigDecimal getAvg(List<BigDecimal> values) {
        BigDecimal res = new BigDecimal(0);
        for (BigDecimal de : values) {
            res = res.add(de);
        }
        return res.divide(new BigDecimal(values.size()), 2);
    }

    class ResData {
        public BigDecimal DATA = null;
        public Date TIME = null;
    }
}
