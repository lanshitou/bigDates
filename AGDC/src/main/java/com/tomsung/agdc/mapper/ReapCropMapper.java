package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.Plant;
import com.tomsung.agdc.domain.ReapCrop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReapCropMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReapCrop record);

    int insertSelective(ReapCrop record);

    ReapCrop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReapCrop record);

    int updateByPrimaryKey(ReapCrop record);

    List<Crop> selectCropByUserId(Integer userId);

    List<Plant> selectPlantByCropId(@Param("cropId") Integer cropId, @Param("userId") Integer userId);

    ReapCrop selectByPlantId(Integer plantId);
}