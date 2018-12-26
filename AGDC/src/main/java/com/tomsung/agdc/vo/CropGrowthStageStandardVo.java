package com.tomsung.agdc.vo;


/**
 * Created by Lvpin on 2018/8/13.
 * 农作物生长标准
 */
public class CropGrowthStageStandardVo {
    private Integer cropId;
    private Integer sort;

    //阶段名称
    private String name;

    //阶段天数
    private Integer stageDays;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStageDays() {
        return stageDays;
    }

    public void setStageDays(Integer stageDays) {
        this.stageDays = stageDays;
    }
}
