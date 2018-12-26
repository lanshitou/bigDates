package com.tomsung.agdc.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.UserEarn;
import com.tomsung.agdc.dto.UserEarnDTO;
import com.tomsung.agdc.mapper.UserEarnMapper;
import com.tomsung.agdc.service.IUserEarnService;
import com.tomsung.agdc.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 10:33
 * @Description:
 */
@Service
public class UserEarnServiceImpl implements IUserEarnService {

    @Autowired
    private UserEarnMapper userEarnMapper;

    @Override
    public List<UnitPriceContrastVO> listUnitPrice(UserEarnDTO dto) {

        List<UserEarn> userEarnList = userEarnMapper.selectList(dto);
        if (CollectionUtils.isEmpty(userEarnList)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        List<UnitPriceContrastVO> resultList = Lists.newArrayList();
        Map<Integer, String> cropMap = Maps.newHashMap();
        Set<Integer> annualSet = Sets.newHashSet();
        Map<UserEarnKeyVO, UserEarn> userEarnMap = Maps.newHashMap();
        for (UserEarn userEarn : userEarnList) {
            cropMap.putIfAbsent(userEarn.getCropId(), userEarn.getCropName());
            UserEarnKeyVO key = new UserEarnKeyVO(userEarn.getCropId(), userEarn.getAnnual());
            userEarnMap.put(key, userEarn);
            annualSet.add(userEarn.getAnnual());
        }
        List<Integer> annualList = Lists.newArrayList(annualSet);
        Collections.sort(annualList);
        for (Integer cropId : cropMap.keySet()) {
            UnitPriceContrastVO vo = new UnitPriceContrastVO(cropId, cropMap.get(cropId));
            for (Integer annual : annualList) {
                vo.getAnnualList().add(annual);
                UserEarn userEarn = userEarnMap.get(new UserEarnKeyVO(cropId, annual));
                if (userEarn == null) {
                    vo.getPlanUnitPriceList().add(new BigDecimal(0));
                    vo.getUnitPriceList().add(new BigDecimal(0));
                } else {
                    vo.getPlanUnitPriceList().add(userEarn.getPlanUnitPrice());
                    vo.getUnitPriceList().add(userEarn.getUnitPrice());
                }
            }
            resultList.add(vo);
        }


        return resultList;
    }

    @Override
    public List<UserEarnIncomeVO> listVarietyIncome(UserEarnDTO dto) {

        List<UserEarn> list = userEarnMapper.selectList(dto);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        List<UserEarnIncomeVO> resultList = Lists.newArrayList();
        for (UserEarn userEarn : list) {
            resultList.add(new UserEarnIncomeVO(userEarn));
        }
        return resultList;
    }

    @Override
    public List<Integer> listAnnual(Integer userId) {

        List<Integer> list = userEarnMapper.selectAnnualByUserId(userId);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<TotalIncomeVO> listTotalIncome(UserEarnDTO dto) {
        List<UserEarn> userEarnList = userEarnMapper.selectList(dto);
        if (CollectionUtils.isEmpty(userEarnList)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        List<TotalIncomeVO> result = Lists.newArrayList();
        for (UserEarn userEarn : userEarnList) {
            boolean exit = false;
            if (CollectionUtils.isNotEmpty(result)) {
                for (TotalIncomeVO vo : result) {
                    if (vo.getAnnual().equals(userEarn.getAnnual())) {
                        exit = true;
                        BigDecimal income = userEarn.getUnitPrice().multiply(new BigDecimal(userEarn.getSalesVolume()));
                        BigDecimal planIncome = userEarn.getPlanUnitPrice().multiply(new BigDecimal(userEarn.getSalesVolume()));
                        vo.setTotalIncome(vo.getTotalIncome().add(income));
                        vo.setPlanIncome(planIncome);
                    }
                }
            }
            if (CollectionUtils.isEmpty(result) || !exit) {
                TotalIncomeVO vo = new TotalIncomeVO();
                vo.setAnnual(userEarn.getAnnual());
                vo.setTotalIncome(userEarn.getUnitPrice().multiply(new BigDecimal(userEarn.getSalesVolume())));
                vo.setPlanIncome(userEarn.getPlanUnitPrice().multiply(new BigDecimal(userEarn.getSalesVolume())));
                result.add(vo);
            }
        }
        return result;
    }

    @Override
    public List<TotalProfitVO> listTotalProfit(UserEarnDTO dto) {

        List<TotalProfitVO> list = userEarnMapper.selectTotalProfit(dto);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }
        return list;
    }

    @Override
    public List<IncomeComparisonVo> getIncomeComparison(Integer cropId, Integer annual) {
        List<AreaAndAvgVo> areaAndAvgVos = userEarnMapper.selectIncomeComparison(cropId, annual, 0);
        IncomeComparisonVo incomeComparisonVo = new IncomeComparisonVo();
        incomeComparisonVo.setName("非自动化用户");
        incomeComparisonVo.setData(areaAndAvgVos);

        List<AreaAndAvgVo> areaAndAvgVos1 = userEarnMapper.selectIncomeComparison(cropId, annual, 1);
        IncomeComparisonVo incomeComparisonVo1 = new IncomeComparisonVo();
        incomeComparisonVo1.setName("自动化用户");
        incomeComparisonVo1.setData(areaAndAvgVos1);
        List<IncomeComparisonVo> incomeComparisonVos = new ArrayList<>();
        incomeComparisonVos.add(incomeComparisonVo);
        incomeComparisonVos.add(incomeComparisonVo1);

        return incomeComparisonVos;
    }

    @Override
    public List<Integer> getEarnAnnual() {
        return userEarnMapper.selectEarnAnnual();
    }

    @Override
    public List<EarnCropVo> getEranCrop(Integer annual) {
        return userEarnMapper.selectEranCrop(annual);
    }
}
