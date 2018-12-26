package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Lvpin on 2018/9/29.
 */
public class OverviewMapVo {
    private String name;
    private List<Object> value;

    public static class Inner {
        private Double blockArea;
        private Integer areaCode;
        private Integer count;
        private BigDecimal addressX;
        private BigDecimal addressY;
        private String name;
        private String cropNames;

        public String getCropNames() {
            return cropNames;
        }

        public void setCropNames(String cropNames) {
            this.cropNames = cropNames;
        }

        public Double getBlockArea() {
            return blockArea;
        }

        public void setBlockArea(Double blockArea) {
            this.blockArea = blockArea;
        }

        public Integer getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(Integer areaCode) {
            this.areaCode = areaCode;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public BigDecimal getAddressX() {
            return addressX;
        }

        public void setAddressX(BigDecimal addressX) {
            this.addressX = addressX;
        }

        public BigDecimal getAddressY() {
            return addressY;
        }

        public void setAddressY(BigDecimal addressY) {
            this.addressY = addressY;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getValue() {
        return value;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }
}
