package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.SoilStandard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SoilStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SoilStandard record);

    int insertSelective(SoilStandard record);

    SoilStandard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SoilStandard record);

    int updateByPrimaryKey(SoilStandard record);

    List<SoilStandard> selectByBlockId(Integer blockId);

    SoilStandard selectById(Integer id);
}