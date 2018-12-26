package com.tomsung.agdc.service;

import com.tomsung.agdc.vo.DeviceVo;
import com.tomsung.agdc.vo.FarmlandPointVo;
import com.tomsung.agdc.vo.FarmlandYieldVo;

import java.util.Date;
import java.util.List;

public interface IFarmlandService {
	List<FarmlandPointVo> getFarmlandList();

	List<FarmlandYieldVo> getFarmlandYieldInfo(Date beginTime, Date endTime);

	List<DeviceVo> getFarmlandDeviceInfo(Integer farmlandId);

}
