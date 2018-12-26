package com.tomsung.agdc.service;

import com.tomsung.agdc.domain.CropGrow;
import com.tomsung.agdc.vo.CropCountVO;

import java.util.Date;
import java.util.List;

public interface ICropService {
    List<CropCountVO> getCropCountVO();

    /**
     * 判断当前作物处在哪一阶段
     */
    String getCropGrowStepName(List<CropGrow> cropGrows, Date plantTIme);
}
