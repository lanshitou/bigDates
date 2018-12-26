package com.tomsung.agdc.service;

import java.util.List;

import com.tomsung.agdc.vo.ProficientActivityVo;
import com.tomsung.agdc.vo.ProficientVo;

public interface IProficientService {
	List<ProficientVo> getAllProficientList();

	List<ProficientActivityVo> getAllProficientActivityList();
}
