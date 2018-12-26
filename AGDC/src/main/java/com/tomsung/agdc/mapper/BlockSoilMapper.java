package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.BlockSoil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BlockSoilMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BlockSoil record);

    int insertSelective(BlockSoil record);

    BlockSoil selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlockSoil record);

    int updateByPrimaryKey(BlockSoil record);

    List<BlockSoil> selectTop3ByBlockId(Integer blockId);
}