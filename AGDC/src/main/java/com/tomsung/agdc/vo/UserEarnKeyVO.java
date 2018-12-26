package com.tomsung.agdc.vo;

import java.util.Objects;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 15:32
 * @Description:
 */
public class UserEarnKeyVO {

    private Integer cropId;

    private Integer annual;

    public UserEarnKeyVO(Integer cropId, Integer annual){
        this.cropId = cropId;
        this.annual = annual;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEarnKeyVO)) return false;
        UserEarnKeyVO that = (UserEarnKeyVO) o;
        return Objects.equals(getCropId(), that.getCropId()) &&
                Objects.equals(getAnnual(), that.getAnnual());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCropId(), getAnnual());
    }
}
