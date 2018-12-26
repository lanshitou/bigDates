package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.service.IBlockService;
import com.tomsung.agdc.service.IPlantService;
import com.tomsung.agdc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
@RestController
@RequestMapping("/sys/block")
public class BlockController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    IBlockService blockService;
    @Autowired
    private IPlantService plantService;

    /**
     * 获取种植户的园区列表
     *
     * @param userId
     * @return
     */
    @GetMapping("/getBlockListByUserId")
    @ApiOperation(value = "获取种植户的园区信息列表")
    public Object getBlockListByUserId(@RequestParam(value = "userId") Integer userId) {
        List<BlockVo> blockListByUserId = blockService.getBlockListByUserId(userId);
        if (CollectionUtils.isNotEmpty(blockListByUserId)) {
            return ResultModel.ok(blockListByUserId);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    /**
     * 获取园区概览（种植信息）
     *
     * @param blockId
     * @return
     */
    @GetMapping("/getOverviewByblockId")
    @ApiOperation(value = "获取园区下的种植信息")
    public Object getOverviewByblockId(@RequestParam(value = "blockId") Integer blockId) {
        List<OverviewVo> overviewByblockId = blockService.getOverviewByblockId(blockId);
        if (CollectionUtils.isNotEmpty(overviewByblockId)) {
            return ResultModel.ok(overviewByblockId);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getDetailByBlockId")
    @ApiOperation(value = "获取园区下详情")
    public Object getDetailByBlockId(@RequestParam(value = "blockId") Integer blockId) {
        UserBlockVo detailByBlockId = blockService.getDetailByBlockId(blockId);
        if (detailByBlockId != null) {
            return ResultModel.ok(detailByBlockId);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_block_rank")
    @ApiOperation(value = "获取园区产量排名")
    public Object getBlockRank() {
        List<BlockRankVo> blockRank = blockService.getBlockRank();
        if (blockRank != null) {
            return ResultModel.ok(blockRank);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/crop_grow")
    @ApiOperation(value = "农作物生长阶段")
    public Object CropGrow(Integer plantId) {

        CropGrowVO vo = blockService.getCropGrow(plantId);

        return ResultModel.ok(vo);
    }


    @GetMapping("/crop_pull_list")
    @ApiOperation(value = "园区种植作物下拉列表")
    public Object getCropList(Integer blockId) {

        List<Crop> list = blockService.listCrop(blockId);

        return ResultModel.ok(list);
    }

    @GetMapping("/plant_pull_list")
    @ApiOperation(value = "批次下拉列表")
    public Object getPlantList(Integer cropId, Integer blockId) {

        List<Plant> list = plantService.listPull(cropId, blockId);

        return ResultModel.ok(list);
    }

    @GetMapping("/get_block_image")
    @ApiOperation(value = "获取园区图片")
    public Object getBlockImage(Integer blockId) {
        List<BlockImageVo> blockImage = blockService.getBlockImage(blockId);
        return ResultModel.ok(blockImage);
    }

    @GetMapping("/get_impair_Annual")
    @ApiOperation(value = "获取病虫害年份")
    public Object getImpairAnnual(@RequestParam(value = "blockId") Integer blockId) {
        List<ImpairAnnualVo> impairAnnual = blockService.getImpairAnnual(blockId);
        return ResultModel.ok(impairAnnual);
    }

    @GetMapping("/get_impair")
    @ApiOperation(value = "获取病虫害")
    public Object getImpair(@RequestParam(value = "blockId") Integer blockId, @RequestParam(value = "annual") String annual) {
        List<ImpairVo> impair = blockService.getImpair(blockId, annual);
        return ResultModel.ok(impair);
    }

    @GetMapping("/get_card_data")
    @ApiOperation(value = "获取卡片数据")
    public Object getCardData() {
        List<BlockDataShowVo> cardData = blockService.getCardData();
        return ResultModel.ok(cardData);
    }

    @GetMapping("/get_block_data_map")
    @ApiOperation(value = "地块数据统计页面地图")
    public Object getBlockDataMap() {
        List<BlockDataMapVo> blockDataMap = blockService.getBlockDataMap();
        return ResultModel.ok(blockDataMap);
    }

    @GetMapping("/get_block_acre_yield")
    @ApiOperation(value = "地块亩产量柱状图")
    public Object getBlockAcreYield(String time,Integer cropId){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<RankVo> list = null;
        try {
            list = blockService.listBlockAcreYield(sdf.parse(time),cropId);
        } catch (ParseException e) {
            return ResultModel.error(ResultStatus.PARAM_ERR);
        }

        return ResultModel.ok(list);
    }

    @GetMapping("get_acre_yield_pull_list")
    @ApiOperation(value = "农作物下拉列表")
    public Object getAcreYieldPullList(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Crop> list = null;
        try {
            list = blockService.listAcreYieldPull(sdf.parse(time));
        } catch (ParseException e) {
            return ResultModel.error(ResultStatus.PARAM_ERR);
        }

        return ResultModel.ok(list);
    }

    @GetMapping("/get_block_is_auto_area")
    @ApiOperation(value = "自动化地块面积排名")
    public Object getBlocIsAutoArea() {
        List<BlockIsAutoAreaVo> blocIsAutoArea = blockService.getBlocIsAutoArea();
        return ResultModel.ok(blocIsAutoArea);
    }
}
