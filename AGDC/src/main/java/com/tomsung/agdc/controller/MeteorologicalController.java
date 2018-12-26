package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.impl.MeteorologicalServiceImpl;
import com.tomsung.agdc.vo.MeteorologicalDataVo;
import com.tomsung.agdc.vo.NowMeteorologicalDataVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lvpin on 2018/9/25.
 * 气象数据
 */
@RestController
@RequestMapping("/sys/meteorological")
public class MeteorologicalController {
    @Autowired
    MeteorologicalServiceImpl meteorologicalServiceImpl;

    @GetMapping("/get_historical_meteorological_data")
    @ApiOperation(value = "获取历史气象数据")
    public Object getHistoricalMeteorologicalData(@RequestParam(value = "blockId") Integer blockId,
                                 @RequestParam(value = "type") Integer type,
                                 @RequestParam(value = "time") String time) {
        List<MeteorologicalDataVo> data = meteorologicalServiceImpl.getMeteorologicalData(blockId, time, type);
        if (CollectionUtils.isNotEmpty(data)) {
            return ResultModel.ok(data);
        }
        return ResultModel.error(ResultStatus.ERR_TEMP_AIR_NO_DATAS);
    }
    @GetMapping("/get_now_meteorological_data")
    @ApiOperation(value = "获取实时气象数据")
    public Object getNowMeteorologicalData(@RequestParam(value = "blockId") Integer blockId) {
        List<NowMeteorologicalDataVo> nowMeteorologicalData = meteorologicalServiceImpl.getNowMeteorologicalData(blockId);
        if (CollectionUtils.isNotEmpty(nowMeteorologicalData)) {
            return ResultModel.ok(nowMeteorologicalData);
        }
        return ResultModel.error(ResultStatus.ERR_TEMP_AIR_NO_DATAS);
    }
}
