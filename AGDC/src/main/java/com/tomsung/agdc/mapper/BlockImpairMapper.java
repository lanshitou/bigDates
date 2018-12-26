package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.BlockImpair;
import com.tomsung.agdc.vo.ImpairAnnualVo;
import com.tomsung.agdc.vo.ImpairVo;
import com.tomsung.agdc.vo.MonthVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Mapper
public interface BlockImpairMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlockImpair record);

    int insertSelective(BlockImpair record);

    BlockImpair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlockImpair record);

    int updateByPrimaryKey(BlockImpair record);

    List<ImpairAnnualVo> selectImpairAnnual(@Param("blockId") Integer blockId);

    List<ImpairVo> selectImpair(@Param("blockId") Integer blockId, @Param("annual") String annual);

    List<MonthVo> getmonth(@Param("impairId") Integer impairId, @Param("blockId") Integer blockId, @Param("annual") String annual);
}