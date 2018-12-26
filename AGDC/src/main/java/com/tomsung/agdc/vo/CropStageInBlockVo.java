package com.tomsung.agdc.vo;

import com.tomsung.agdc.domain.CropGrow;

import java.util.Date;

/**
 * Created by Lvpin on 2018/9/7.
 * 园区下农作物生长阶段
 */
public class CropStageInBlockVo {
    private Integer cropId;
    private Integer blockId;
    private String cropName;
    private String batch;
    private Date sproutTime; //发芽时间
    private CropGrow cropGrow;

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Date getSproutTime() {
        return sproutTime;
    }

    public void setSproutTime(Date sproutTime) {
        this.sproutTime = sproutTime;
    }

    public CropGrow getCropGrow() {
        return cropGrow;
    }

    public void setCropGrow(CropGrow cropGrow) {
        this.cropGrow = cropGrow;
    }
}
