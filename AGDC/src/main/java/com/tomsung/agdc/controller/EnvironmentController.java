package com.tomsung.agdc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tomsung.agdc.common.DevType;
import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IEnvironmentService;
import com.tomsung.agdc.vo.EnvironmentVo;

import io.swagger.annotations.ApiOperation;


/**
 * 环境信息相关查询接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sys/environment")
public class EnvironmentController {

	@Autowired
	private IEnvironmentService environmentService;
	 
	@GetMapping("/get_temperature_air")
    @ApiOperation(value = "获取空气温度")
    public Object getTempAir(@RequestParam(value = "farmlandId") Integer farmlandId,
                          @RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
                          @RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                          ) {
        EnvironmentVo temperatureList = environmentService.getTemperatureList(farmlandId, beginTime, endTime, DevType.AIR_H_AND_T_SENSOR.getKey());
        EnvironmentVo data = temperatureList;
        if (data != null) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_TEMP_AIR_NO_DATAS);
    }
	
	
	@GetMapping("/get_temperature_soil")
    @ApiOperation(value = "获取土壤温度")
    public Object getTempSoil(@RequestParam(value = "farmlandId") Integer farmlandId,
                          @RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
                          @RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                          ) {
		EnvironmentVo data = environmentService.getTemperatureList(farmlandId, beginTime, endTime, DevType.SOIL_TEMP_SENSOR.getKey());
        if (data != null) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_TEMP_SOIL_NO_DATAS);
    }
	
	@GetMapping("/get_humidity_air")
    @ApiOperation(value = "获取空气湿度")
    public Object getHumidityAir(@RequestParam(value = "farmlandId") Integer farmlandId,
                          @RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
                          @RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                          ) {
		EnvironmentVo data = environmentService.getHumidityList(farmlandId, beginTime, endTime, DevType.AIR_H_AND_T_SENSOR.getKey());
        if (data != null) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_HUMIDITY_AIR_NO_DATAS);
    }
	
	@GetMapping("/get_humidity_soil")
    @ApiOperation(value = "获取土壤湿度")
    public Object getHumiditySoil(@RequestParam(value = "farmlandId") Integer farmlandId,
                          @RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
                          @RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                          ) {
		EnvironmentVo data = environmentService.getHumidityList(farmlandId, beginTime, endTime, DevType.SOIL_HUMI_SENSOR.getKey());
        if (data != null) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_HUNIDITY_SOIL_NO_DATAS);
    }
	
	@GetMapping("/get_co2")
    @ApiOperation(value = "获取二氧化碳")
    public Object getCo2(@RequestParam(value = "farmlandId") Integer farmlandId,
                          @RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
                          @RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                          ) {
        EnvironmentVo data = environmentService.getCO2List(farmlandId, beginTime, endTime);
        if (data != null) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_CO2_NO_DATAS);
    }
	
	@GetMapping("/get_beamstrength")
    @ApiOperation(value = "获取光照强度")
    public Object getBeamStrength(@RequestParam(value = "farmlandId") Integer farmlandId,
                          @RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
                          @RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime
                          ) {
		EnvironmentVo data = environmentService.getBeamstrengthList(farmlandId, beginTime, endTime);
        if (data != null) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_BEAMSTRENGTH_NO_DATAS);
    }
}
