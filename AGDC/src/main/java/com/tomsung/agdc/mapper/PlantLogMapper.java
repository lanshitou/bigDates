package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.PlantLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PlantLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlantLog record);

    int insertSelective(PlantLog record);

    PlantLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlantLog record);

    int updateByPrimaryKeyWithBLOBs(PlantLog record);

    int updateByPrimaryKey(PlantLog record);

    List<PlantLog> selectByPlantId(Integer plantId);

    List<PlantLog> selectByUserId(Integer userId);

    List<PlantLog> selectAll();
}