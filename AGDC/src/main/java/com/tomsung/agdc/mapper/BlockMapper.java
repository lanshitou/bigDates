package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.Block;
import com.tomsung.agdc.domain.Crop;
import com.tomsung.agdc.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Lvpin on 2018/8/13.
 */
@Mapper
@Component
public interface BlockMapper {

    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    /**
     * 根据种植户Id获取园区列表
     */
    List<BlockVo> selectBlockListByUserId(Integer UserId);

    /**
     * 根据园区Id获取园区概览（种植信息）
     */
    List<OverviewVo> selectOverviewByblockId(@Param("blockId") Integer blockId);

    List<UserBlockVo> selectDetailByBlockId(@Param("blockId") Integer blockId);

    List<BlockRankVo> selectBlockRank();

    Double selectBlockAreaTotal(@Param("date") Date date);

    Integer selectBlockCount(Date date);

    List<FarmlandYieldVo> selectFarmlandYieldInfo(@Param(value = "beginTime") Date beginTime, @Param(value = "endTime") Date endTime);

    List<FarmlandPointVo> selectAllFarmlandPoints();

    List<RankVo> selectContractUserYield();

    List<AreaSizeRankVo> selectFarmlandArea();

    Integer cropCount(@Param("areaCode") Integer areaCode);

    Integer selectAllCropCount();

    Integer selectAllBlockCount();

    List<OverviewMapVo.Inner> selectOverviewMap();

    List<String> selectCropNames(@Param("areaCode") Integer areaCode);

    Integer selectBlockCityCount(@Param("date") Date date);

    List<BlockDataMapVo> selectBlockDataMap(@Param("type") Integer type);

    List<BlockIsAutoAreaVo> selectBlocIsAutoArea();

    List<RankVo> selectBlockAcreYield(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("cropId") Integer cropId);

    List<Crop> selectAllReapCropByTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
