package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IOrderService;
import com.tomsung.agdc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sys/order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping("/get_count")
    @ApiOperation(value = "获取八个卡片上的数量")
    public Object getCount() {
        List<CountVo> list = orderService.getCountList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_order_product")
    @ApiOperation(value = "订单肥料类型占比")
    public Object getConsistOfProduct() {
        List<RankVo> list = orderService.getOrderGroupByProduct();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_order_rank")
    @ApiOperation(value = "地区订单数排名")
    public Object getOrderRank(@RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                               @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<RankVo> list = orderService.getOrderGroupByDistrict(beginTime,endTime);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_order_count")
    @ApiOperation(value = "订单走势")
    public Object getOrderCount(@RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                               @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<RankVo> list = orderService.getOrderCount(beginTime,endTime);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_order_district")
    @ApiOperation(value = "销售区域")
    public Object getOrderDistrict() {
        List<MapVo> list = orderService.getOrderDistrict();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_order_company")
    @ApiOperation(value = "厂商订单销量")
    public Object getOrderCompany() {
        List<CompanyVo> list = orderService.getOrderCompany();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_order_flight")
    @ApiOperation(value = "航线")
    public Object getOrderFlight() {
        List list = orderService.getOrderFlight();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }
}
