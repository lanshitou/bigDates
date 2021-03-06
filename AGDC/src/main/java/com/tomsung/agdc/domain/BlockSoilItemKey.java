package com.tomsung.agdc.domain;

public class BlockSoilItemKey {
    private Integer blockSoilId;

    private Integer itemId;

    public Integer getBlockSoilId() {
        return blockSoilId;
    }

    public void setBlockSoilId(Integer blockSoilId) {
        this.blockSoilId = blockSoilId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
        BlockSoilItemKey other = (BlockSoilItemKey) that;
        return (this.getBlockSoilId() == null ? other.getBlockSoilId() == null : this.getBlockSoilId().equals(other.getBlockSoilId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlockSoilId() == null) ? 0 : getBlockSoilId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        return result;
    }
}