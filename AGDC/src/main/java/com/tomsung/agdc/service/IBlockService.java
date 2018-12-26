package com.tomsung.agdc.service;

import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.vo.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
public interface IBlockService {

    // 获取种植户的园区列表
    List<BlockVo> getBlockListByUserId(Integer userId);

    // 获取园区概览
    List<OverviewVo> getOverviewByblockId(Integer blockId);

    UserBlockVo getDetailByBlockId(Integer blockId);

    List<BlockVideoVo> getBlockVideoByBlockId(Integer userId, Integer blockId);

    List<BlockRankVo> getBlockRank();

    List<Crop> listCrop(Integer blockId);

    CropGrowVO getCropGrow(Integer plantId);

    List<BlockImageVo> getBlockImage(Integer blockId);

    List<ImpairAnnualVo> getImpairAnnual(Integer blockId);

    List<ImpairVo> getImpair(Integer blockId, String annual);

    List<BlockDataShowVo> getCardData();

    List<BlockDataMapVo> getBlockDataMap();

    List<RankVo> listBlockAcreYield(Date time, Integer cropId);

    List<Crop> listAcreYieldPull(Date time);

    List<BlockIsAutoAreaVo> getBlocIsAutoArea();
}
