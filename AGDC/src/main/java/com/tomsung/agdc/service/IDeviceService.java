package com.tomsung.agdc.service;

import com.tomsung.agdc.vo.DeviceCountVo;
import com.tomsung.agdc.vo.SensorVo;

import java.util.List;

/**
 * Created by Lvpin on 2018/9/10.
 */
public interface IDeviceService {
    List<DeviceCountVo> getDeviceCount();

    List<SensorVo> getSensors();

}
