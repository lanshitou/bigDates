package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.service.impl.DeviceServiceImpl;
import com.tomsung.agdc.vo.MemberCountVO;
import com.tomsung.agdc.vo.SensorVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lvpin on 2018/9/13.
 */
@RestController
@RequestMapping("/sys/device")
public class SensorController {
    @Autowired
    DeviceServiceImpl deviceServiceImpl;

    @GetMapping("/get_all_sensor")
    @ApiOperation(value = "传感器统计")
    public Object getAllSensor() {
        List<SensorVo> sensors = deviceServiceImpl.getSensors();
        if (sensors != null) {
            return ResultModel.ok(sensors);
        } else {
            return ResultModel.ok(new SensorVo());
        }
    }
}
