package com.tomsung.agdc.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.ISaleService;
import com.tomsung.agdc.vo.SaleDetailInfoVo;
import com.tomsung.agdc.vo.SaleTotalVo;

import io.swagger.annotations.ApiOperation;


/**
 * 销售信息相关查询接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/sys/sale")
public class SaleController {

	@Autowired
	private ISaleService saleService;
	 
	@GetMapping("/get_all_sale_pionts")
    @ApiOperation(value = "获取所有销售区域销售信息列表")
    public Object listAll() {
        List<SaleTotalVo> saleDetails = saleService.getSaleDetails();
        if (CollectionUtils.isNotEmpty(saleDetails)) {
            return ResultModel.ok(saleDetails);
        }
        return ResultModel.error(ResultStatus.ERR_SALE_NO_DATAS);
    }
	
	@GetMapping("/get_sale_detail")
    @ApiOperation(value = "获取某区域的销售信息列表")
    public Object getSaleDetails(
    		@RequestParam(value = "provinceId") Integer provinceId,
    		@RequestParam(value = "cityId") Integer cityId,
    		@RequestParam(value = "districtId") Integer districtId) {
        List<SaleTotalVo> saleDetails = saleService.getSaleDetailByAdd(provinceId, cityId, districtId);
        if (CollectionUtils.isNotEmpty(saleDetails)) {
            return ResultModel.ok(saleDetails);
        }
        return ResultModel.error(ResultStatus.ERR_SALE_NO_DATAS_ADD);
    }
	
	@GetMapping("/get_point_sale_detail")
    @ApiOperation(value = "获取所有自提点的销售信息列表")
    public Object getPointSaleDetails() {
        List<SaleDetailInfoVo> saleDetails = saleService.getPointSaleDetails();
        if (CollectionUtils.isNotEmpty(saleDetails)) {
            return ResultModel.ok(saleDetails);
        }
        return ResultModel.error(ResultStatus.ERR_SALE_NO_DATAS_ADD);
    }
	
	@GetMapping("/get_sale_detail_user")
    @ApiOperation(value = "获取指定用户的销售信息列表")
    public Object getSaleDetailsByUser(@RequestParam(value = "userId") Integer userId) {
        List<SaleDetailInfoVo> saleDetails = saleService.getSaleDetailsByUser(userId);
        if (CollectionUtils.isNotEmpty(saleDetails)) {
            return ResultModel.ok(saleDetails);
        }
        return ResultModel.error(ResultStatus.ERR_SALE_NO_DATAS_ADD);
    }
	
}
