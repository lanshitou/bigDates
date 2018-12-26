package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.BlockFertilizationItem;
import com.tomsung.agdc.domain.BlockFertilizationItemKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BlockFertilizationItemMapper {
    int deleteByPrimaryKey(BlockFertilizationItemKey key);

    int insert(BlockFertilizationItem record);

    int insertSelective(BlockFertilizationItem record);

    BlockFertilizationItem selectByPrimaryKey(BlockFertilizationItemKey key);

    int updateByPrimaryKeySelective(BlockFertilizationItem record);

    int updateByPrimaryKey(BlockFertilizationItem record);

    List<BlockFertilizationItem> selectByBlockSoilAndStandard(@Param("blockSoilId") Integer blockSoilId, @Param("standardId") Integer standardId);

    int insertBatch(List<BlockFertilizationItem> list);
}