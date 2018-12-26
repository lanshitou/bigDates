package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tomsung.agdc.domain.BlockSoil;
import com.tomsung.agdc.domain.BlockSoilItem;

import java.util.Date;
import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/6 16:20
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockSoilDetailVO {

    private Integer id;

    private Integer blockId;

    private Date surveyTime;

    private Integer sampleDepth;

    private List<BlockSoilItem> items;

    public BlockSoilDetailVO(){}

    public BlockSoilDetailVO(BlockSoil blockSoil){

        id = blockSoil.getId();
        blockId = blockSoil.getBlockId();
        surveyTime = blockSoil.getSurveyTime();
        sampleDepth = blockSoil.getSampleDepth();

    }

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

    public List<BlockSoilItem> getItems() {
        return items;
    }

    public void setItems(List<BlockSoilItem> items) {
        this.items = items;
    }
}
