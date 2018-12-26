package com.tomsung.agdc.service;

import java.util.List;

import com.tomsung.agdc.vo.SaleDetailInfoVo;
import com.tomsung.agdc.vo.SaleTotalVo;

public interface ISaleService {
	List<SaleTotalVo> getSaleDetails();

	List<SaleTotalVo> getSaleDetailByAdd(Integer provinceId, Integer cityId, Integer districtId);

	List<SaleDetailInfoVo> getPointSaleDetails();

	List<SaleDetailInfoVo> getSaleDetailsByUser(Integer userId);
}
