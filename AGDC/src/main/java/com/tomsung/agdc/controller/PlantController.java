package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.PlantLog;
import com.tomsung.agdc.service.IPlantService;
import com.tomsung.agdc.vo.BlockOutputRankVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/21 15:14
 * @Description:
 */
@RestController
@RequestMapping("/sys/plant")
public class PlantController {

    @Autowired
    private IPlantService plantService;

    @GetMapping("/crop_pull_list")
    @ApiOperation("种植作物下拉列表")
    public Object cropPullList(Integer userId) {

        List<Crop> list = plantService.listCrop(userId);

        return ResultModel.ok(list);
    }

    @GetMapping("/batch_pull_list")
    @ApiOperation("批次下拉列表")
    public Object batchPullList(Integer userId, Integer cropId) {

        List<Plant> list = plantService.listByUserAndCrop(userId, cropId);

        return ResultModel.ok(list);
    }

    @GetMapping("/log_list")
    @ApiOperation("农事记录列表")
    public Object plantLogList(Integer plantId) {
        List<PlantLog> list = plantService.listLog(plantId);
        return ResultModel.ok(list);
    }

    @GetMapping("/get_block_output_rank")
    @ApiOperation("地块产量排名")
    public Object getBlockOutputRank(@RequestParam(value = "annual") String annual, @RequestParam(value = "cropId") Integer cropId) {
        List<BlockOutputRankVo> blockOutputRank = plantService.getBlockOutputRank(annual, cropId);
        return ResultModel.ok(blockOutputRank);
    }

}
