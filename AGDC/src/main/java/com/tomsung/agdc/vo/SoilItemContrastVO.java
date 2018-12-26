package com.tomsung.agdc.vo;

import java.math.BigDecimal;

/**
 * @author: zhangqi
 * @Date: 2018/9/10 10:50
 * @Description:
 */
public class SoilItemContrastVO {

    private Integer itemId;

    private String itemName;

    private String abbreviation;

    private BigDecimal standardValue;

    private BigDecimal value;

    private Byte unit;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public BigDecimal getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(BigDecimal standardValue) {
        this.standardValue = standardValue;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Byte getUnit() {
        return unit;
    }

    public void setUnit(Byte unit) {
        this.unit = unit;
    }
}
