package com.tomsung.agdc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockSoil {
    private Integer id;

    private Integer blockId;

    private Date surveyTime;

    private Integer sampleDepth;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Date getSurveyTime() {
        return surveyTime;
    }

    public void setSurveyTime(Date surveyTime) {
        this.surveyTime = surveyTime;
    }

    public Integer getSampleDepth() {
        return sampleDepth;
    }

    public void setSampleDepth(Integer sampleDepth) {
        this.sampleDepth = sampleDepth;
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
        BlockSoil other = (BlockSoil) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBlockId() == null ? other.getBlockId() == null : this.getBlockId().equals(other.getBlockId()))
            && (this.getSurveyTime() == null ? other.getSurveyTime() == null : this.getSurveyTime().equals(other.getSurveyTime()))
            && (this.getSampleDepth() == null ? other.getSampleDepth() == null : this.getSampleDepth().equals(other.getSampleDepth()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBlockId() == null) ? 0 : getBlockId().hashCode());
        result = prime * result + ((getSurveyTime() == null) ? 0 : getSurveyTime().hashCode());
        result = prime * result + ((getSampleDepth() == null) ? 0 : getSampleDepth().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}