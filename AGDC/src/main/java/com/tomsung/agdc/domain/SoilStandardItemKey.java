package com.tomsung.agdc.domain;

public class SoilStandardItemKey {
    private Integer soilStandardId;

    private Integer itemId;

    public Integer getSoilStandardId() {
        return soilStandardId;
    }

    public void setSoilStandardId(Integer soilStandardId) {
        this.soilStandardId = soilStandardId;
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
        SoilStandardItemKey other = (SoilStandardItemKey) that;
        return (this.getSoilStandardId() == null ? other.getSoilStandardId() == null : this.getSoilStandardId().equals(other.getSoilStandardId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSoilStandardId() == null) ? 0 : getSoilStandardId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        return result;
    }
}