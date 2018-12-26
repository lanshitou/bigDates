package com.tomsung.agdc.service;

import com.tomsung.agdc.dto.UserEarnDTO;
import com.tomsung.agdc.vo.*;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 10:32
 * @Description:
 */
public interface IUserEarnService {

    List<UnitPriceContrastVO> listUnitPrice(UserEarnDTO dto);

    List<UserEarnIncomeVO> listVarietyIncome(UserEarnDTO dto);

    List<Integer> listAnnual(Integer userId);

    List<TotalIncomeVO> listTotalIncome(UserEarnDTO dto);

    List<TotalProfitVO> listTotalProfit(UserEarnDTO dto);

    List<IncomeComparisonVo> getIncomeComparison(Integer cropId, Integer annual);

    List<Integer> getEarnAnnual();

    List<EarnCropVo> getEranCrop(Integer annual);
}
