package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.SuggestionItemProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SuggestionItemProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SuggestionItemProduct record);

    int insertSelective(SuggestionItemProduct record);

    SuggestionItemProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SuggestionItemProduct record);

    int updateByPrimaryKey(SuggestionItemProduct record);

    List<SuggestionItemProduct> selectSuggestionId(Integer suggestionId);
}