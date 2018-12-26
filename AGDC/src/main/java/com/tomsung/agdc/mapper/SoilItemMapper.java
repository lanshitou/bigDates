package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.SoilItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface SoilItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SoilItem record);

    int insertSelective(SoilItem record);

    SoilItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoilItem record);

    int updateByPrimaryKey(SoilItem record);
}