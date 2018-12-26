package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.BlockSoilItem;
import com.tomsung.agdc.domain.BlockSoilItemKey;
import com.tomsung.agdc.vo.ItemVo;
import com.tomsung.agdc.vo.SoilItemContentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BlockSoilItemMapper {
    int deleteByPrimaryKey(BlockSoilItemKey key);

    int insert(BlockSoilItem record);

    int insertSelective(BlockSoilItem record);

    BlockSoilItem selectByPrimaryKey(BlockSoilItemKey key);

    int updateByPrimaryKeySelective(BlockSoilItem record);

    int updateByPrimaryKey(BlockSoilItem record);

    List<BlockSoilItem> selectByBlockSoilId(Integer blockSoilId);

    //土壤元素测量
    List<SoilItemContentVo> selectSurveyContent(@Param("userId") Integer userId);

    //土壤元素标准
    List<ItemVo> selectStandardContent(@Param("cropId") Integer cropId);
}