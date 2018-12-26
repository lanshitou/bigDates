package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.domain.SaleDetail;
import com.tomsung.agdc.mapper.SaleDetailMapper;
import com.tomsung.agdc.service.ISaleService;
import com.tomsung.agdc.vo.SaleDetailInfoVo;
import com.tomsung.agdc.vo.SaleTotalVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SaleServiceImpl implements ISaleService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SaleDetailMapper saleDetailMapper;
	
	@Override
	public List<SaleTotalVo> getSaleDetails() {
		List<SaleTotalVo> res = new ArrayList<SaleTotalVo>();
		try
		{
			List<SaleDetail> details = saleDetailMapper.selectAllSaleDetails();
			if(details != null)
			{
				Map<String, SaleTotalVo> temp = processSaleData(details);
				res = new ArrayList<SaleTotalVo>(temp.values());
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	private Map<String, SaleTotalVo> processSaleData(List<SaleDetail> details) {
		Map<String, SaleTotalVo> temp = new HashMap<String, SaleTotalVo>();
		for(SaleDetail detail : details)
		{
			String key = detail.getProduct().getName() + detail.getProvince().getProvincename()
					+ detail.getCity().getCityname() + detail.getDistrict().getDistrictname();
			SaleTotalVo vo = temp.get(key);
			if (vo != null)
			{
				vo.saleTotalNum.add(detail.getSaleCount());
				vo.saleTotalPrice.add(detail.getProduct().getPrice().multiply(detail.getSaleCount()));
				vo.saleTotalWeight.add(detail.getProduct().getWeight().multiply(detail.getSaleCount()));
			}
			else
			{
				vo = new SaleTotalVo();
				vo.productName = detail.getProduct().getName();
				vo.provinceName = detail.getProvince().getProvincename();
				vo.cityName = detail.getCity().getCityname();
				vo.districtName = detail.getDistrict().getDistrictname();
				vo.address = detail.getAddress();
				vo.saleTotalNum = detail.getSaleCount();
				vo.saleTotalPrice = detail.getProduct().getPrice().multiply(detail.getSaleCount());
				vo.saleTotalWeight = detail.getProduct().getWeight().multiply(detail.getSaleCount());
				temp.put(key, vo);
			}
		}
		return temp;
	}
	@Override
	public List<SaleTotalVo> getSaleDetailByAdd(Integer provinceId, Integer cityId, Integer districtId) {

		List<SaleTotalVo> res = new ArrayList<SaleTotalVo>();
		try
		{
			List<SaleDetail> details = saleDetailMapper.selectSaleDetails(provinceId, cityId, districtId);
			Map<String, SaleTotalVo> temp = processSaleData(details);
			res = new ArrayList<SaleTotalVo>(temp.values());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	@Override
	public List<SaleDetailInfoVo> getPointSaleDetails() {
		
		List<SaleDetailInfoVo> res = new ArrayList<SaleDetailInfoVo>();
		try
		{
			res = processDetailInfo(saleDetailMapper.selectPointSaleDetails());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return res;
	}
	private List<SaleDetailInfoVo> processDetailInfo(List<SaleDetail> selectPointSaleDetails) {
		List<SaleDetailInfoVo> res = new ArrayList<SaleDetailInfoVo>();
		if (CollectionUtils.isNotEmpty(selectPointSaleDetails))
		{
			for (SaleDetail detail : selectPointSaleDetails)
			{
				SaleDetailInfoVo vo = new SaleDetailInfoVo();
				res.add(vo);
				vo.productName = detail.getProduct().getName();
				vo.provinceName = detail.getProvince().getProvincename();
				vo.cityName = detail.getCity().getCityname();
				vo.districtName = detail.getDistrict().getDistrictname();
				vo.address = detail.getAddress();
				vo.saleNum = detail.getSaleCount();
				vo.salePrice = detail.getProduct().getPrice();
				vo.saleWeight = detail.getProduct().getWeight();
				vo.saleTime = detail.getSaleTime();
			}
		}
		return res;
	}
	@Override
	public List<SaleDetailInfoVo> getSaleDetailsByUser(Integer userId) {
		List<SaleDetailInfoVo> res = new ArrayList<SaleDetailInfoVo>();
		try
		{
			res = processDetailInfo(saleDetailMapper.selectSaleDetailsByUser(userId));
		}
		catch(Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return res;
	}

}
