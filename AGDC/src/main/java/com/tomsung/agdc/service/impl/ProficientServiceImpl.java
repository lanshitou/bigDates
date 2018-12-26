package com.tomsung.agdc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomsung.agdc.domain.ProficientCropKey;
import com.tomsung.agdc.mapper.ProficientCropMapper;
import com.tomsung.agdc.service.IProficientService;
import com.tomsung.agdc.vo.ProficientActivityVo;
import com.tomsung.agdc.vo.ProficientVo;
@Service
public class ProficientServiceImpl implements IProficientService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProficientCropMapper proficientCropMapper;
	
	@Override
	public List<ProficientVo> getAllProficientList() {
		List<ProficientVo> vos = new ArrayList<ProficientVo>();
		try
		{
			List<ProficientCropKey> proficients = proficientCropMapper.selectAllProficients();
			if (CollectionUtils.isNotEmpty(proficients))
			{
				vos = processProficientData(proficients);
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		
		return vos;
	}

	private List<ProficientVo> processProficientData(List<ProficientCropKey> proficients) {
		List<ProficientVo> vos = new ArrayList<ProficientVo>();
		for (ProficientCropKey pc : proficients)
		{
			ProficientVo vo = new ProficientVo();
			vos.add(vo);
			vo.userName = pc.getUser().getUsername();
			vo.provinceName = pc.getUser().getPrivinceName();
			vo.cityName = pc.getUser().getCityName();
			vo.districtName = pc.getUser().getDistrictName();
			vo.cropName = pc.getCrop().getCropName();
		}
		return vos;
	}

	@Override
	public List<ProficientActivityVo> getAllProficientActivityList() {
		List<ProficientActivityVo> actVos = new ArrayList<ProficientActivityVo>();
		try
		{
			List<ProficientCropKey> proficientCrops = proficientCropMapper.selectAllProficients();
			if (CollectionUtils.isNotEmpty(proficientCrops))
			{
				actVos = processProficientCropData(proficientCrops);
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return actVos;
	}

	private List<ProficientActivityVo> processProficientCropData(List<ProficientCropKey> proficientCrops) {
		List<ProficientActivityVo> actVos = new ArrayList<ProficientActivityVo>();
		for (ProficientCropKey pc : proficientCrops)
		{
			ProficientActivityVo vo = new ProficientActivityVo();
			actVos.add(vo);
			vo.userName = pc.getUser().getUsername();
			vo.provinceName = pc.getUser().getPrivinceName();
			vo.cityName = pc.getUser().getCityName();
			vo.districtName = pc.getUser().getDistrictName();
			vo.cropName = pc.getCrop().getCropName();
			vo.replyCount = pc.getQuestionReplyRecord().getReplyCount();
		}
		return actVos;
	}

}
