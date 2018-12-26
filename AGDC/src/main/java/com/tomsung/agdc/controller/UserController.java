package com.tomsung.agdc.controller;

import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.common.ResultModel;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.domain.User;
import com.tomsung.agdc.dto.TraderIncomeCompareDTO;
import com.tomsung.agdc.dto.TraderPurchaseCompareDTO;
import com.tomsung.agdc.mapper.SaleDetailMapper;
import com.tomsung.agdc.mapper.UserMapper;
import com.tomsung.agdc.service.IUserService;
import com.tomsung.agdc.vo.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 用户信息相关查询接口
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IUserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SaleDetailMapper saleDetailMapper;

    @GetMapping("/listAll")
    @ApiOperation(value = "获取所有用户列表")
    public Object listAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<User> users = userService.getUserList(pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(users.getList())) {
            return ResultModel.ok(users);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }


    @GetMapping("/get_activity_users")
    @ApiOperation(value = "获取所有活跃用户列表")
    public Object getActivityUsers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<ActivityUserVo> users = userService.getAllActivityUserList(pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(users)) {
            return ResultModel.ok(users);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_usercount")
    @ApiOperation(value = "获取四个卡片用户数")
    public Object getUserCount() {
        List<CountVo> list = userService.getCountList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_map")
    @ApiOperation(value = "获取地图分布")
    public Object getUserMap() {
        List<MapVo> list = userService.getUserMapSpread();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_usercount_rank")
    @ApiOperation(value = "获取用户数省份排名")
    public Object getUserRank(@RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                              @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<RankVo> list = userService.getUserCountRank(beginTime, endTime);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_rise")
    @ApiOperation(value = "签约用户和非签约用户数量统计分析")
    public Object getUserRise(@RequestParam(value = "beginTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
                              @RequestParam(value = "endTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        List<MapVo> list = userService.getContractUserCountList(beginTime, endTime);
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_liveness")
    @ApiOperation(value = "近半年签约用户和非签约活跃度")
    public Object getUserLiveness() {
        List<MapVo> list = userService.getUserLiveness();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_yield_rank")
    @ApiOperation(value = "获取产量排名")
    public Object getYieldRank() {
        List<RankVo> list = userService.getYieldRank();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/update_longtitude")
    @ApiOperation(value = "更新地址经纬度")
    public Object updateLongtitude() {
        int result = userService.updateLongtitude();
        if (result > 0) {
            return ResultModel.ok();
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getUserNameAndAddressList")
    @ApiOperation(value = "获取所有用户在地图的分布信息")
    public Object getUserNameAndAddressList() {
        List<UserNameAndAddressVo> list = userService.getUserNameAndAddressList();
        if (CollectionUtils.isNotEmpty(list)) {
            return ResultModel.ok(list);
        }
        return ResultModel.error(ResultStatus.NO_DATA);
    }

    @GetMapping("/getFarmerUserList")
    @ApiOperation(value = "获取种植户信息列表")
    public Object getFarmerUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "like") String like) {
        PageInfo<FarmerUserVo> farmerUserList = userService.getFarmerUserList(pageNum, pageSize, like);
        if (CollectionUtils.isNotEmpty(farmerUserList.getList())) {
            return ResultModel.ok(farmerUserList);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getTraderUserList")
    @ApiOperation(value = "获取贸易商信息列表")
    public Object getPersonTraderUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "type") Integer type,
                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Object traderUserList1 = userService.getTraderUserList(type, pageNum, pageSize);
        return ResultModel.ok(traderUserList1);
    }

    @GetMapping("/getStationUserList")
    @ApiOperation(value = "获取站长信息列表")
    public Object getStationUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "like") String like) {
        PageInfo<StationUserVo> stationUserList = userService.getStationUserList(pageNum, pageSize, like);
        if (CollectionUtils.isNotEmpty(stationUserList.getList())) {
            return ResultModel.ok(stationUserList);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getExpertUserList")
    @ApiOperation(value = "获取专家信息列表")
    public Object getExpertUserList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageInfo<ExpertUserVo> expertUserList = userService.getExpertUserList(pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(expertUserList.getList())) {
            return ResultModel.ok(expertUserList);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getFarmerUserDetails")
    @ApiOperation(value = "获取种植户信息详情")
    public Object getFarmerUserList(@RequestParam(value = "userId") Integer userId) {
        FarmerUserDetailsVo farmerUserDetailsVo = userService.getFarmerUserDetails(userId);
        if (farmerUserDetailsVo != null) {
            return ResultModel.ok(farmerUserDetailsVo);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getPersonTraderUserDetails")
    @ApiOperation(value = "获取个人贸易商用户详情")
    public Object getPersonTraderUserDetails(@RequestParam(value = "userId") Integer userId) {
        PersonTraderUserDetailsVo personTraderUserDetails = userService.getPersonTraderUserDetails(userId);
        if (personTraderUserDetails != null) {
            return ResultModel.ok(personTraderUserDetails);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getStationUserDetails")
    @ApiOperation(value = "获取站长用户详情")
    public Object getStationUserDetails(@RequestParam(value = "userId") Integer userId) {
        StationUserDetailsVo stationUserDetails = userService.getStationUserDetails(userId);
        if (stationUserDetails != null) {
            return ResultModel.ok(stationUserDetails);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/getExpertUserDetails")
    @ApiOperation(value = "获取专家用户详情")
    public Object getExpertUserDetails(@RequestParam(value = "userId") Integer userId) {
        ExpertUserDetailsVo expertUserDetails = userService.getExpertUserDetails(userId);
        if (expertUserDetails != null) {
            return ResultModel.ok(expertUserDetails);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_detail_by_user_id")
    @ApiOperation(value = "获取用户详情")
    public Object getUserDetailByUserId(@RequestParam(value = "userId") Integer userId) {
        UserDetailVo userDetailVo = userService.getUserDetailByUserId(userId);
        if (userDetailVo != null) {
            return ResultModel.ok(userDetailVo);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_and_Blocks")
    @ApiOperation(value = "决策中心获取用户园区")
    public Object getUserAndBlocks() {
        List<UserAndBlocksVo> userAndBlocksVos = userService.selectUserAndBlocks();
        if (userAndBlocksVos != null) {
            return ResultModel.ok(userAndBlocksVos);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_area_rank")
    @ApiOperation(value = "区域排名")
    public Object getAreaRank() {
        List<AreaRankVo> areaRankVos = userService.selectAreaRank();
        if (areaRankVos != null) {
            return ResultModel.ok(areaRankVos);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_active")
    @ApiOperation(value = "获取用户专家活跃度")
    public Object getUserActive() {
        List<ActiveCountVo> activeCountVos = userService.selectActive();
        if (activeCountVos != null) {
            return ResultModel.ok(activeCountVos);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_enterprise_trade_user_details")
    @ApiOperation(value = "获取企业贸易商详情")
    public Object getEnterpriseTradeUserDetails(@RequestParam(value = "userId") Integer userId) {
        EnterpriseTradeUserDetailsVo enterpriseTradeUserDetails = userService.getEnterpriseTradeUserDetails(userId);
        if (enterpriseTradeUserDetails != null) {
            return ResultModel.ok(enterpriseTradeUserDetails);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_area_user_rank")
    @ApiOperation(value = "获取区域用户数量排名")
    public Object getAreaUserRank(String beginTime, String endTime) {
        List<AreaUserRankVo> areaUserRank = userService.getAreaUserRank(beginTime, endTime);
        if (areaUserRank != null) {
            return ResultModel.ok(areaUserRank);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @GetMapping("/get_user_distribution")
    @ApiOperation(value = "获取用户分布信息")
    public Object getUserDistribution() {
        List<UserDistributionVo> userDistribution = null;
        try {
            userDistribution = userService.getUserDistribution();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        if (userDistribution != null) {
            return ResultModel.ok(userDistribution);
        }
        return ResultModel.error(ResultStatus.ERR_USER_NO_DATAS);
    }

    @PostMapping("/trader_detail_compare_pull")
    @ApiOperation("贸易商详细信息 → 收购数量对比下拉框")
    public Object traderDetailYearsPull(@RequestParam(value = "userId") Integer userId) {
        return ResultModel.ok(userService.traderDetailYearsPull(userId));
    }

    @PostMapping("/trader_purchase_compare")
    @ApiOperation("贸易商详细信息 → 收购数量对比")
    public Object traderPurchaseCompare(TraderPurchaseCompareDTO dto) {
        return ResultModel.ok(userService.traderPurchaseCompare(dto));
    }

    @PostMapping("/trader_income_compare_pull")
    @ApiOperation("贸易商详细信息 → 收入对比下拉框")
    public Object traderIncomeComparePull(@RequestParam(value = "userId") Integer userId) {
        return ResultModel.ok(userService.traderIncomeComparePull(userId));
    }

    @PostMapping("/trader_income_compare")
    @ApiOperation("贸易商详细信息 → 收入对比")
    public Object traderIncomeCompare(TraderIncomeCompareDTO dto) {
        return ResultModel.ok(userService.traderIncomeCompare(dto));
    }

    @PostMapping("/station_members")
    @ApiOperation("个人信息 → 会员列表")
    public Object getStationMembers(@RequestParam(value = "userId") Integer userId) {
        return ResultModel.ok(userService.getStationMembers(userId));
    }

    @PostMapping("/station_members_distribute")
    @ApiOperation("个人信息 → 会员分布")
    public Object getStationMembersDistribute(@RequestParam(value = "userId") Integer userId) {
        return ResultModel.ok(userService.getStationMembersDistribute(userId));
    }
}
