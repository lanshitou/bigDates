package com.tomsung.agdc.vo;

import java.util.Date;

/**
 * 园区概览
 * Created by Lvpin on 2018/8/14.
 */
public class OverviewVo {
    private Integer blockId;
    private String cropName;
    private Double cropArea;
    private Integer scene;
    private Date reapTime;//上市时间
    private Date growTime;
    private Integer planOutput;
    private Integer annual;
    private Integer summ;

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public Integer getSumm() {
        return summ;
    }

    public void setSumm(Integer summ) {
        this.summ = summ;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Date getReapTime() {
        return reapTime;
    }

    public void setReapTime(Date reapTime) {
        this.reapTime = reapTime;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Double getCropArea() {
        return cropArea;
    }

    public void setCropArea(Double cropArea) {
        this.cropArea = cropArea;
    }

    public Integer getScene() {
        return scene;
    }

    public void setScene(Integer scene) {
        this.scene = scene;
    }

    public Date getGrowTime() {
        return growTime;
    }

    public void setGrowTime(Date growTime) {
        this.growTime = growTime;
    }

    public Integer getPlanOutput() {
        return planOutput;
    }

    public void setPlanOutput(Integer planOutput) {
        this.planOutput = planOutput;
    }
}
