package com.tomsung.agdc.domain;

import java.util.Date;
import java.util.Objects;

public class PlantLog {
    private Integer id;

    private Integer userId;

    private String userName;

    private Integer plantId;

    private String plantType;

    private String plantDetail;

    private Integer plantTime;

    private Byte result;

    private Date createTime;

    private Date updateTime;

    private String plantImages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType == null ? null : plantType.trim();
    }

    public String getPlantDetail() {
        return plantDetail;
    }

    public void setPlantDetail(String plantDetail) {
        this.plantDetail = plantDetail == null ? null : plantDetail.trim();
    }

    public Integer getPlantTime() {
        return plantTime;
    }

    public void setPlantTime(Integer plantTime) {
        this.plantTime = plantTime;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlantImages() {
        return plantImages;
    }

    public void setPlantImages(String plantImages) {
        this.plantImages = plantImages == null ? null : plantImages.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlantLog)) return false;
        PlantLog plantLog = (PlantLog) o;
        return Objects.equals(getId(), plantLog.getId()) &&
                Objects.equals(getUserId(), plantLog.getUserId()) &&
                Objects.equals(getUserName(), plantLog.getUserName()) &&
                Objects.equals(getPlantId(), plantLog.getPlantId()) &&
                Objects.equals(getPlantType(), plantLog.getPlantType()) &&
                Objects.equals(getPlantDetail(), plantLog.getPlantDetail()) &&
                Objects.equals(getPlantTime(), plantLog.getPlantTime()) &&
                Objects.equals(getResult(), plantLog.getResult()) &&
                Objects.equals(getCreateTime(), plantLog.getCreateTime()) &&
                Objects.equals(getUpdateTime(), plantLog.getUpdateTime()) &&
                Objects.equals(getPlantImages(), plantLog.getPlantImages());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUserId(), getUserName(), getPlantId(), getPlantType(), getPlantDetail(), getPlantTime(), getResult(), getCreateTime(), getUpdateTime(), getPlantImages());
    }
}