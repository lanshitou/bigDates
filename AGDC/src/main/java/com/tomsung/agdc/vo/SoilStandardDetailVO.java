package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tomsung.agdc.domain.SoilStandard;
import com.tomsung.agdc.domain.SoilStandardItem;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/6 18:12
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoilStandardDetailVO {

    private Integer id;

    private Integer cropId;

    private String name;

    private Integer output;

    private List<SoilStandardItem> items;

    public SoilStandardDetailVO(){}

    public SoilStandardDetailVO(SoilStandard soilStandard){

        id = soilStandard.getId();
        cropId = soilStandard.getCropId();
        name = soilStandard.getName();
        output = soilStandard.getOutput();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public List<SoilStandardItem> getItems() {
        return items;
    }

    public void setItems(List<SoilStandardItem> items) {
        this.items = items;
    }
}
