package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tomsung.agdc.domain.CropGrow;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 19:28
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CropGrowItemVO {

    private String name;

    private String imageUrl;

    private Integer days;

    private Boolean step;

    private Integer width;

    public CropGrowItemVO(){}

    public CropGrowItemVO(CropGrow cropGrow){
        name = cropGrow.getName();
        imageUrl = cropGrow.getImageUrl();
        days = cropGrow.getStageDays();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Boolean getStep() {
        return step;
    }

    public void setStep(Boolean step) {
        this.step = step;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
