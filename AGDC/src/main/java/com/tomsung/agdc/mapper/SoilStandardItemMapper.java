package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.SoilStandardItem;
import com.tomsung.agdc.domain.SoilStandardItemKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SoilStandardItemMapper {
    int deleteByPrimaryKey(SoilStandardItemKey key);

    int insert(SoilStandardItem record);

    int insertSelective(SoilStandardItem record);

    SoilStandardItem selectByPrimaryKey(SoilStandardItemKey key);

    int updateByPrimaryKeySelective(SoilStandardItem record);

    int updateByPrimaryKey(SoilStandardItem record);

    List<SoilStandardItem> selectByStandardId(Integer standardId);
}