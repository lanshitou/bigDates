package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.Plant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface PlantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plant record);

    int insertSelective(Plant record);

    Plant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plant record);

    int updateByPrimaryKey(Plant record);

    List<Plant> selectByCropIdAndBlockId(@Param("cropId") Integer cropId, @Param("blockId") Integer blockId);

    Plant selectById(Integer id);

    List<Plant> selectByCropAndUser(@Param("cropId") Integer corpId, @Param("userId") Integer userId);

    Integer selectOutputSum(@Param("date") Date date);
}