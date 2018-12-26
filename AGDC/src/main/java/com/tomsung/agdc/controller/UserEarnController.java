package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.dto.UserEarnDTO;
import com.tomsung.agdc.service.IUserEarnService;
import com.tomsung.agdc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/17 10:31
 * @Description:
 */
@RestController
@RequestMapping("/sys/user_earn")
public class UserEarnController {

    @Autowired
    private IUserEarnService userEarnService;

    @GetMapping("/unit_price_contrast")
    @ApiOperation(value = "单价对比")
    public Object listUnitPriceContrast(UserEarnDTO dto) {

        List<UnitPriceContrastVO> list = userEarnService.listUnitPrice(dto);

        return ResultModel.ok(list);
    }

    @GetMapping("/variety_income_contrast")
    @ApiOperation(value = "品种收入对比")
    public Object listVarietyIncomeContrast(UserEarnDTO dto) {

        List<UserEarnIncomeVO> list = userEarnService.listVarietyIncome(dto);

        return ResultModel.ok(list);
    }

    @GetMapping("/annual_list")
    @ApiOperation(value = "年份下拉列表")
    public Object listAnnual(Integer userId) {

        List<Integer> list = userEarnService.listAnnual(userId);

        return ResultModel.ok(list);
    }

    @GetMapping("/total_income")
    @ApiOperation(value = "总收入对比")
    public Object listTotalIncome(UserEarnDTO dto) {

        List<TotalIncomeVO> list = userEarnService.listTotalIncome(dto);

        return ResultModel.ok(list);
    }

    @GetMapping("/total_profit")
    @ApiOperation(value = "总利润对比")
    public Object listTotalProfit(UserEarnDTO dto) {

        List<TotalProfitVO> list = userEarnService.listTotalProfit(dto);

        return ResultModel.ok(list);
    }

    @GetMapping("/get_income_comparison")
    @ApiOperation(value = "收益对比分析")
    public Object getIncomeComparison(@RequestParam(value = "cropId") Integer cropId, @RequestParam("annual") Integer annual) {
        List<IncomeComparisonVo> incomeComparison = userEarnService.getIncomeComparison(cropId, annual);
        return ResultModel.ok(incomeComparison);
    }

    @GetMapping("/get_earn_annual")
    @ApiOperation(value = "收益年份")
    public Object getEarnAnnual() {
        List<Integer> earnAnnual = userEarnService.getEarnAnnual();
        return ResultModel.ok(earnAnnual);
    }

    @GetMapping("/get_earn_crop")
    @ApiOperation(value = "收益作物")
    public Object getEarnCrop(@RequestParam(value = "annual") Integer annual) {
        List<EarnCropVo> eranCrop = userEarnService.getEranCrop(annual);
        return ResultModel.ok(eranCrop);
    }

}
