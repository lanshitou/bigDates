package com.tomsung.agdc.controller;

import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.service.IHomeService;
import com.tomsung.agdc.service.IUserService;
import com.tomsung.agdc.vo.CountVo;
import com.tomsung.agdc.vo.MapVo;
import com.tomsung.agdc.vo.OverviewMapVo;
import com.tomsung.agdc.vo.RankVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sys/home")
public class HomeController {
    @Autowired
    IHomeService homeService;
    @Autowired
    IUserService userService;

    @GetMapping("/get_count")
    @ApiOperation(value = "获取八个卡片上的数量")
    public Object getCount() {
        List<CountVo> list = homeService.getCountList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_usercount_rank")
    @ApiOperation(value = "获取地区用户数排名")
    public Object getUserRank(@RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                              @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<RankVo> list = userService.getContractUserCountRank(beginTime, endTime);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_solved_rate_crop")
    @ApiOperation(value = "解答率按作物")
    public Object getSolvedRateByCrop() {
        List<RankVo> list = homeService.getRateListByCrop();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_solved_rate_city")
    @ApiOperation(value = "解答率按城市")
    public Object getSolvedRateByCity() {
        List<RankVo> list = homeService.getRateListByCity();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_suggestion_sales")
    @ApiOperation(value = "方案销售比")
    public Object getSuggestionSales(@RequestParam Integer id) {
        List<RankVo> list = homeService.getSuggestionSales(id);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_farmland")
    @ApiOperation(value = "地块列表")
    public Object getFarmRank() {
        List<Object> resData = homeService.getFarmRank();
        if (CollectionUtils.isNotEmpty(resData)) {
            return ResultModel.ok(resData);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_farmland_spread")
    @ApiOperation(value = "大棚分布地图")
    public Object getFarmSpread() {
        List<OverviewMapVo> farmSpread = homeService.getFarmSpread();
        if (CollectionUtils.isNotEmpty(farmSpread)) {
            return ResultModel.ok(farmSpread);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_rise")
    @ApiOperation(value = "签约用户和注册用户数量统计分析")
    public Object getUserRise(@Param("type") Integer type,
                              @RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                              @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<MapVo> list = null;
        if (type != null) {
            list = homeService.getContractUserCountLists(type);
        } else {
            list = homeService.getContractUserCountList(beginTime, endTime);
        }
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }
}
