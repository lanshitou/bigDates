package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.mapper.CropGrowthStageMapper;
import com.tomsung.agdc.service.ICropGrowthStageService;
import com.tomsung.agdc.vo.CropGrowItemVO;
import com.tomsung.agdc.vo.CropStageInBlockVo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
@Service
public class CropGrowthStageServiceImpl implements ICropGrowthStageService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CropGrowthStageMapper cropGrowthStageMapper;

    @Override
    public List<CropStageInBlockVo> getCropGrowthStage(Integer blockId) {
        try {
            List<CropStageInBlockVo> cropStageInBlockVos = cropGrowthStageMapper.selectCropGrowthStage(blockId);
            if (CollectionUtils.isNotEmpty(cropStageInBlockVos)) {
                return cropStageInBlockVos;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new ArrayList();
    }

}
