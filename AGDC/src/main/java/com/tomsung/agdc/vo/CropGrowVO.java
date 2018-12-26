package com.tomsung.agdc.vo;

import java.util.Date;
import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/20 17:52
 * @Description:
 */
public class CropGrowVO {

    private Date sproutTime;

    private Date ripeTime;

    private List<CropGrowItemVO> items;

    public Date getSproutTime() {
        return sproutTime;
    }

    public void setSproutTime(Date sproutTime) {
        this.sproutTime = sproutTime;
    }

    public Date getRipeTime() {
        return ripeTime;
    }

    public void setRipeTime(Date ripeTime) {
        this.ripeTime = ripeTime;
    }

    public List<CropGrowItemVO> getItems() {
        return items;
    }

    public void setItems(List<CropGrowItemVO> items) {
        this.items = items;
    }
}
