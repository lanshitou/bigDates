package com.tomsung.agdc.mapper;

import com.tomsung.agdc.vo.CropGrowthStageVo;
import com.tomsung.agdc.vo.CropStageInBlockVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
@Mapper
@Component
public interface CropGrowthStageMapper {
    /**
     * 根据园区ID获取农作物生长阶段
     */
    List<CropStageInBlockVo> selectCropGrowthStage(Integer blockId);
}
