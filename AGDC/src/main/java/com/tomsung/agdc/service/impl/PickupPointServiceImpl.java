package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.mapper.PickupPointMapper;
import com.tomsung.agdc.service.IPickupPointService;
import com.tomsung.agdc.vo.PickupPointVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickupPointServiceImpl implements IPickupPointService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PickupPointMapper pickupPointMapper;


	@Override
	public List<PickupPointVo> getAllPickupPointList() {
		return null;
	}
}
