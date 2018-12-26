package com.tomsung.agdc.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IPickupPointService;
import com.tomsung.agdc.vo.PickupPointVo;

import io.swagger.annotations.ApiOperation;


/**
 * 自提点信息相关查询接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sys/pickup")
public class PickupPointController {

	@Autowired
	private IPickupPointService pickupPointService;
	 
	@GetMapping("/get_all_pickup_points")
    @ApiOperation(value = "获取所有自提点列表")
    public Object getAllPickupPoints() {
        List<PickupPointVo> points = pickupPointService.getAllPickupPointList();
        if (CollectionUtils.isNotEmpty(points)) {
            return ResultModel.ok(points);
        }
        return ResultModel.error(ResultStatus.ERR_PICKUP_POINT_NO_DATAS);
    }
}
