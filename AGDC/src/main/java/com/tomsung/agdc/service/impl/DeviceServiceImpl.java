package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.common.DevType;
import com.tomsung.agdc.mapper.DeviceMapper;
import com.tomsung.agdc.service.IDeviceService;
import com.tomsung.agdc.vo.DeviceCountVo;
import com.tomsung.agdc.vo.SensorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lvpin on 2018/9/10.
 */
@Service
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<DeviceCountVo> getDeviceCount() {
        //首部控制器统计
        DeviceCountVo iuc = new DeviceCountVo();
        iuc.setDeviceName("首部控制器");
        List<Byte> iucNO = new ArrayList<>();
        iucNO.add(DevType.IUC.getKey());
        iuc.setCount(deviceMapper.count(iucNO));

        //田间控制器统计
        DeviceCountVo ict = new DeviceCountVo();
        ict.setDeviceName("田间控制器");
        List<Byte> ictNO = new ArrayList<>();
        ictNO.add(DevType.ICT.getKey());
        ict.setCount(deviceMapper.count(ictNO));

        //水泵统计
        DeviceCountVo pump = new DeviceCountVo();
        pump.setDeviceName("水泵");
        List<Byte> pumpNo = new ArrayList<>();
        pumpNo.add(DevType.PUMP.getKey());
        pump.setCount(deviceMapper.count(pumpNo));

        //阀门统计
        DeviceCountVo valve = new DeviceCountVo();
        valve.setDeviceName("阀门");
        List<Byte> valveNo = new ArrayList<>();
        valveNo.add(DevType.ELEC_VALVE.getKey());
        valveNo.add(DevType.ELEC_MAGNETIC_VALVE.getKey());
        valve.setCount(deviceMapper.count(valveNo));

        //传感器统计
        DeviceCountVo sensor = new DeviceCountVo();
        sensor.setDeviceName("传感器");
        List<Byte> sensorNo = new ArrayList<>();
        sensorNo.add(DevType.SOIL_HUMI_SENSOR.getKey());
        sensorNo.add(DevType.SOIL_H_AND_T_SENSOR.getKey());
        sensorNo.add(DevType.AIR_HUMI_SENSOR.getKey());
        sensorNo.add(DevType.AIR_TEMP_SENSOR.getKey());
        sensorNo.add(DevType.AIR_H_AND_T_SENSOR.getKey());
        sensorNo.add(DevType.LIGHT_INTENSITY.getKey());
        sensorNo.add(DevType.CO2_SENSOR.getKey());
        sensorNo.add(DevType.SENSOE_ALL.getKey());
        sensor.setCount(deviceMapper.count(sensorNo));

        //风机统计
        DeviceCountVo fan = new DeviceCountVo();
        fan.setDeviceName("风机");
        List<Byte> fanNo = new ArrayList<>();
        fanNo.add(DevType.FAN.getKey());
        fan.setCount(deviceMapper.count(fanNo));


        ArrayList<DeviceCountVo> deviceVos = new ArrayList<>();
        deviceVos.add(iuc);
        deviceVos.add(ict);
        deviceVos.add(pump);
        deviceVos.add(valve);
        deviceVos.add(sensor);
        deviceVos.add(fan);
        return deviceVos;
    }

    /**
     * 获取所有传感器
     *
     * @param
     * @return
     */
    @Override
    public List<SensorVo> getSensors() {
        List<Byte> allSensorKey = DeviceServiceImpl.getAllSensorKey();
        List<SensorVo> sensorVos = deviceMapper.selectSensorCountByKey(allSensorKey);
        for (SensorVo sensorVo : sensorVos) {
            sensorVo.setName(DevType.getDevTypeName(sensorVo.getType()));
        }
        return sensorVos;
    }

    private static List<Byte> getAllSensorKey() {
        List<Byte> sensorKeys = new ArrayList<>();
        sensorKeys.add(DevType.SOIL_HUMI_SENSOR.getKey());
        sensorKeys.add(DevType.SOIL_H_AND_T_SENSOR.getKey());
        sensorKeys.add(DevType.AIR_HUMI_SENSOR.getKey());
        sensorKeys.add(DevType.AIR_TEMP_SENSOR.getKey());
        sensorKeys.add(DevType.AIR_H_AND_T_SENSOR.getKey());
        sensorKeys.add(DevType.LIGHT_INTENSITY.getKey());
        sensorKeys.add(DevType.CO2_SENSOR.getKey());
        sensorKeys.add(DevType.SENSOE_ALL.getKey());
        return sensorKeys;
    }
}
