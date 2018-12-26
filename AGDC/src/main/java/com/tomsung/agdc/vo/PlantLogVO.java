package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tomsung.agdc.domain.PlantLog;

import java.util.Date;

/**
 * @author: zhangqi
 * @Date: 2018/9/25 10:43
 * @Description:
 */
public class PlantLogVO {

    private Integer id;

    private String userName;

    private String plantingType;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

    public PlantLogVO(PlantLog plantLog) {
        id = plantLog.getId();
        userName = plantLog.getUserName();
        plantingType = plantLog.getPlantType();
        addTime = new Date((Long.parseLong(plantLog.getPlantTime().toString())) * 1000);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlantingType() {
        return plantingType;
    }

    public void setPlantingType(String plantingType) {
        this.plantingType = plantingType;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
