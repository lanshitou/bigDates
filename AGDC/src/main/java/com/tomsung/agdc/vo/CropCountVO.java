package com.tomsung.agdc.vo;

import java.math.BigDecimal;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/10 20:17
 */
public class CropCountVO {
    private BigDecimal area;
    private String name;
    private BigDecimal percent;

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }
}
