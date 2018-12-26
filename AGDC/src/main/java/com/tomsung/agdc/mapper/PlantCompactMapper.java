package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.domain.PlantCompact;
import com.tomsung.agdc.vo.BlockOutputRankVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface PlantCompactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlantCompact record);

    int insertSelective(PlantCompact record);

    PlantCompact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlantCompact record);

    int updateByPrimaryKey(PlantCompact record);

    List<Crop> selectCropByUserId(Integer userId);

    Integer selectCropCount(@Param("date") Date date);

    List<BlockOutputRankVo> selectBlockOutputRank(@Param("annual") String annual, @Param("cropId") Integer cropId);
}