package com.tomsung.agdc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tomsung.agdc.domain.SuggestionItemProduct;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/20 16:45
 * @Description:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuggestionVO {

    private String name;

    private List<SuggestionItemProduct> productList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuggestionItemProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<SuggestionItemProduct> productList) {
        this.productList = productList;
    }
}
