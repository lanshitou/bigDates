package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.ReapCrop;
import com.tomsung.agdc.service.IReapCropService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/18 16:12
 * @Description:
 */
@RestController
@RequestMapping("/sys/reap_crop")
public class ReapCropController {

    @Autowired
    private IReapCropService reapCropService;

    @GetMapping("/crop_pull_list")
    @ApiOperation("农作物下拉列表")
    public Object getCropPullList(Integer userId){

        List<Crop> list = reapCropService.listCrop(userId);

        return ResultModel.ok(list);
    }

    @GetMapping("/plant_pull_list")
    @ApiOperation("种植批次下拉列表")
    public Object getPlantPullList(Integer cropId,Integer userId){

        List<Plant> list = reapCropService.listPlant(cropId,userId);

        return ResultModel.ok(list);
    }

    @GetMapping("/detail")
    @ApiOperation("产品详情")
    public Object getReapCrop(Integer id){

        ReapCrop reapCrop = reapCropService.getReapCrop(id);

        return ResultModel.ok(reapCrop);
    }

}
