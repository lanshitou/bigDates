package com.tomsung.agdc.service;

import java.util.Date;

import com.tomsung.agdc.domain.Temperature;
import com.tomsung.agdc.vo.EnvironmentVo;

public interface IEnvironmentService {
	/**
	 * 按照传感器类型查询空气或者土壤温度
	 * @param farmlandId
	 * @param beginTime
	 * @param endTime
	 * @param devType
	 * @return
	 */
	EnvironmentVo getTemperatureList(Integer farmlandId, Date beginTime, Date endTime, int devType);
	
	/**
	 * 按照传感器类型查询空气或者土壤湿度
	 * @param farmlandId
	 * @param beginTime
	 * @param endTime
	 * @param devType
	 * @return
	 */
	EnvironmentVo getHumidityList(Integer farmlandId, Date beginTime, Date endTime, int devType);	
	
	/**
	 * 获取地块的CO2
	 * @param farmlandId
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	EnvironmentVo getCO2List(Integer farmlandId, Date beginTime, Date endTime);
	
	/**
	 * 获取光照强度
	 * @param farmlandId
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	EnvironmentVo getBeamstrengthList(Integer farmlandId, Date beginTime, Date endTime);

	boolean addTemperature(Temperature temperature);
	
}
