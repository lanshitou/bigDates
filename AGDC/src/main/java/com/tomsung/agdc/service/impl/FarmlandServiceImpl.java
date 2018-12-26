package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.common.DevType;
import com.tomsung.agdc.domain.Device;
import com.tomsung.agdc.mapper.BlockMapper;
import com.tomsung.agdc.mapper.CropMapper;
import com.tomsung.agdc.mapper.DeviceMapper;
import com.tomsung.agdc.service.IFarmlandService;
import com.tomsung.agdc.vo.DeviceVo;
import com.tomsung.agdc.vo.FarmlandPointVo;
import com.tomsung.agdc.vo.FarmlandYieldVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FarmlandServiceImpl implements IFarmlandService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CropMapper cropMapper;

	@Autowired
	BlockMapper blockMapper;

	@Autowired
	DeviceMapper deviceMapper;

	@Override
	public List<FarmlandPointVo> getFarmlandList() {
		try {
			List<FarmlandPointVo> farmlandPointVos = blockMapper.selectAllFarmlandPoints();
			if (CollectionUtils.isNotEmpty(farmlandPointVos)) {
				return farmlandPointVos;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ArrayList<FarmlandPointVo>();
	}

	@Override
	public List<FarmlandYieldVo> getFarmlandYieldInfo(Date beginTime, Date endTime) {
		try {
			List<FarmlandYieldVo> farmlandYieldVos = blockMapper.selectFarmlandYieldInfo(beginTime, endTime);
			if (CollectionUtils.isNotEmpty(farmlandYieldVos)) {
				return farmlandYieldVos;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	@Override
	public List<DeviceVo> getFarmlandDeviceInfo(Integer farmlandId) {
		List<DeviceVo> res = new ArrayList<DeviceVo>();
		try
		{
			res = processDeviceData(deviceMapper.selectDevices(farmlandId));
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	private List<DeviceVo> processDeviceData(List<Device> selectDevices) {
		List<DeviceVo> res = new ArrayList<DeviceVo>();
		if (CollectionUtils.isNotEmpty(selectDevices))
		{
			for (Device device : selectDevices)
			{
				DeviceVo vo = new DeviceVo();
				vo.deviceId = device.getDeviceid();
				vo.deviceName = device.getName();
				vo.deviceType = DevType.getDevTypeName(device.getDevicetype().byteValue());
				res.add(vo);
			}
		}
		return res;
	}
}
