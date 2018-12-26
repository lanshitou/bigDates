package com.tomsung.agdc.service;

import com.tomsung.agdc.vo.CropGrowItemVO;
import com.tomsung.agdc.vo.CropStageInBlockVo;

import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
public interface ICropGrowthStageService {
    // 根据园区Id获取农作物生长阶段
    List<CropStageInBlockVo> getCropGrowthStage(Integer blockId);

}
