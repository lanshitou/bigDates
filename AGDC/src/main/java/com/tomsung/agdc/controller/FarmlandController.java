package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IFarmlandService;
import com.tomsung.agdc.vo.DeviceVo;
import com.tomsung.agdc.vo.FarmlandPointVo;
import com.tomsung.agdc.vo.FarmlandYieldVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * 大棚或大田相关查询接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sys/farmland")
public class FarmlandController {

	@Autowired
	private IFarmlandService farmlandService;
	 
	@GetMapping("/farmland_point")
    @ApiOperation(value = "获取所有大棚或大田的经纬度列表")
    public Object listFarmlandPoints() {
        List<FarmlandPointVo> farmlandPoints = farmlandService.getFarmlandList();
        if (CollectionUtils.isNotEmpty(farmlandPoints)) {
            return ResultModel.ok(farmlandPoints);
        }
        return ResultModel.error(ResultStatus.ERR_FARMLAND_XY_NO_DATAS);
    }


	@GetMapping("/farmland_yield_info")
    @ApiOperation(value = "获取在某点时间大棚或大田的产量信息")
    public Object getFarmlandYieldInfo(@RequestParam(value = "beginTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date beginTime,
    		@RequestParam(value = "endTime")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime) {
        List<FarmlandYieldVo> farmlandYieldVo = farmlandService.getFarmlandYieldInfo(beginTime, endTime);
        if (CollectionUtils.isNotEmpty(farmlandYieldVo)) {
            return ResultModel.ok(farmlandYieldVo);
        }
        return ResultModel.error(ResultStatus.ERR_FARMLAND_YIELD_NO_DATAS);
    }
	
	@GetMapping("/farmland_device_info")
    @ApiOperation(value = "获取某大棚或大田的设备信息")
    public Object getFarmlandDeviceInfo(@RequestParam(value = "farmlandId") Integer farmlandId) {
        List<DeviceVo> devices = farmlandService.getFarmlandDeviceInfo(farmlandId);
        if (devices != null) {
            return ResultModel.ok(devices);
        }
        return ResultModel.error(ResultStatus.ERR_FARMLAND_DEVICE_NO_DATAS);
    }
}
