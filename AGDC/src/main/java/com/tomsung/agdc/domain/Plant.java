package com.tomsung.agdc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Plant {
    private Integer id;

    private Integer compactId;

    private Integer annual;

    private String batch;

    private Integer output;

    private Date sproutTime;

    private Date reapTime;

    private Date createTime;

    private Date updateTime;

    private Integer cropId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompactId() {
        return compactId;
    }

    public void setCompactId(Integer compactId) {
        this.compactId = compactId;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public Date getSproutTime() {
        return sproutTime;
    }

    public void setSproutTime(Date sproutTime) {
        this.sproutTime = sproutTime;
    }

    public Date getReapTime() {
        return reapTime;
    }

    public void setReapTime(Date reapTime) {
        this.reapTime = reapTime;
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

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Plant other = (Plant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompactId() == null ? other.getCompactId() == null : this.getCompactId().equals(other.getCompactId()))
            && (this.getAnnual() == null ? other.getAnnual() == null : this.getAnnual().equals(other.getAnnual()))
            && (this.getBatch() == null ? other.getBatch() == null : this.getBatch().equals(other.getBatch()))
            && (this.getOutput() == null ? other.getOutput() == null : this.getOutput().equals(other.getOutput()))
            && (this.getSproutTime() == null ? other.getSproutTime() == null : this.getSproutTime().equals(other.getSproutTime()))
            && (this.getReapTime() == null ? other.getReapTime() == null : this.getReapTime().equals(other.getReapTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompactId() == null) ? 0 : getCompactId().hashCode());
        result = prime * result + ((getAnnual() == null) ? 0 : getAnnual().hashCode());
        result = prime * result + ((getBatch() == null) ? 0 : getBatch().hashCode());
        result = prime * result + ((getOutput() == null) ? 0 : getOutput().hashCode());
        result = prime * result + ((getSproutTime() == null) ? 0 : getSproutTime().hashCode());
        result = prime * result + ((getReapTime() == null) ? 0 : getReapTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}