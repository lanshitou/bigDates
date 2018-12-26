package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.UserEarn;
import com.tomsung.agdc.dto.UserEarnDTO;
import com.tomsung.agdc.vo.AreaAndAvgVo;
import com.tomsung.agdc.vo.EarnCropVo;
import com.tomsung.agdc.vo.TotalProfitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserEarnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEarn record);

    int insertSelective(UserEarn record);

    UserEarn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEarn record);

    int updateByPrimaryKey(UserEarn record);

    List<UserEarn> selectList(UserEarnDTO dto);

    List<Integer> selectAnnualByUserId(Integer userId);

    List<TotalProfitVO> selectTotalProfit(UserEarnDTO dto);

    List<AreaAndAvgVo> selectIncomeComparison(@Param("crop_id") Integer crop_id, @Param("annual") Integer annual, @Param("type") Integer type);

    List<Integer> selectEarnAnnual();

    List<EarnCropVo> selectEranCrop(@Param("annual") Integer annual);
}