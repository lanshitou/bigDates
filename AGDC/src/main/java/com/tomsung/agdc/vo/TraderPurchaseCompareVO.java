package com.tomsung.agdc.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wang hao
 * @Description:
 * @Date Create in 2018/9/25 14:39
 */
public class TraderPurchaseCompareVO {
    private BigDecimal subsidy;
    private List<InnerClass> detail;

    public static class InnerClass{
        private Integer year;
        private BigDecimal count;

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public BigDecimal getCount() {
            return count;
        }

        public void setCount(BigDecimal count) {
            this.count = count;
        }
    }

    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    public List<InnerClass> getDetail() {
        return detail;
    }

    public void setDetail(List<InnerClass> detail) {
        this.detail = detail;
    }
}
