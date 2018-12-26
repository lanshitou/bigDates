package com.tomsung.agdc.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 * 农作物生长阶段
 * 标准
 */
public class CropGrowthStageVo {
    public String cropName;
    public String batch;
    public Date growTime;
    public List<CropGrowthStageStandardVo> cropGrowthStageStandardVo;

}
