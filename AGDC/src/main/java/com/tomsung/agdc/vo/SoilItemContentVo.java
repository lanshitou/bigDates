package com.tomsung.agdc.vo;

import java.util.List;

/**
 * Created by Lvpin on 2018/9/11.
 */
public class SoilItemContentVo {
    private Integer blockId;
    private Integer cropId;
    private String blockName;
    private List<ItemVo> itemVos;

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public List<ItemVo> getItemVos() {
        return itemVos;
    }

    public void setItemVos(List<ItemVo> itemVos) {
        this.itemVos = itemVos;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

}
