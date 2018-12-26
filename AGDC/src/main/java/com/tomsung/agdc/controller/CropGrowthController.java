package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.ICropGrowthStageService;
import com.tomsung.agdc.vo.CropGrowthStageVo;
import com.tomsung.agdc.vo.CropStageInBlockVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
@RestController
@RequestMapping("/sys/cropGrowthStage")
public class CropGrowthController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ICropGrowthStageService cropGrowthStageService;
    /**
     * 根据园区Id获取农作物生长阶段
     *
     * @param blockId
     * @return
     */
    @GetMapping("/getCropGrowthStage")
    @ApiOperation(value = "获取种植户的园区信息列表")
    public Object getCropGrowthStage(@RequestParam(value = "blockId") Integer blockId) {
        List<CropStageInBlockVo> cropStageInBlockVos = cropGrowthStageService.getCropGrowthStage(blockId);
        if (CollectionUtils.isNotEmpty(cropStageInBlockVos)) {
            return ResultModel.ok(cropStageInBlockVos);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }
}
