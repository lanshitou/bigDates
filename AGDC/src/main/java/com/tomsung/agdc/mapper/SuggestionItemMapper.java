package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.SuggestionItem;
import com.tomsung.agdc.domain.SuggestionItemWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SuggestionItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SuggestionItemWithBLOBs record);

    int insertSelective(SuggestionItemWithBLOBs record);

    SuggestionItemWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SuggestionItemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SuggestionItemWithBLOBs record);

    int updateByPrimaryKey(SuggestionItem record);
}