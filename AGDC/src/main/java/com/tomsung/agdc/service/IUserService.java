package com.tomsung.agdc.service;

import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.domain.SaleDetail;
import com.tomsung.agdc.domain.User;
import com.tomsung.agdc.dto.TraderIncomeCompareDTO;
import com.tomsung.agdc.dto.TraderPurchaseCompareDTO;
import com.tomsung.agdc.vo.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IUserService {
    PageInfo<User> getUserList(int pageNum, int pageSize);

//    PageInfo<Farmland> getFarmlandUserDetail(Integer userId, int pageNum, int pageSize);

    PageInfo<SaleDetail> getZhxnUserDetail(Integer userId, int pageNum, int pageSize);

    List<ActivityUserVo> getAllActivityUserList(int pageNum, int pageSize);

    //四张卡片上的用户数量
    List<CountVo> getCountList();

    //地图分布
    List<MapVo> getUserMapSpread();

    //用户排名按省
    List<RankVo> getUserCountRank(Date beginTime, Date endTime);

    //签约用户,非签约用户数量
    List<MapVo> getContractUserCountList(Date beginTime, Date endTime);

    //签约用户,非签约用户活跃度
    List<MapVo> getUserLiveness();

    //签约用户产量排名
    List<RankVo> getYieldRank();

    //签约用户按区排名
    List<RankVo> getContractUserCountRank(Date beginTime, Date endTime);

    int updateLongtitude();

    //获取用户在地图上的分布信息
    List<UserNameAndAddressVo> getUserNameAndAddressList();

    //获取种植户信息列表
    PageInfo<FarmerUserVo> getFarmerUserList(int pageNum, int pageSize, String like);

    //获取贸易商信息列表
    Object getTraderUserList(Integer type, int pageNum, int pageSize);

    //获取站长信息列表
    PageInfo<StationUserVo> getStationUserList(int pageNum, int pageSize, String like);

    //获取专家信息列表
    PageInfo<ExpertUserVo> getExpertUserList(int pageNum, int pageSize);

    //获取种植户详情
    FarmerUserDetailsVo getFarmerUserDetails(Integer userId);

    //获取个人贸易商用户详情
    PersonTraderUserDetailsVo getPersonTraderUserDetails(Integer userid);

    //获取企业贸易商用户详情
    EnterpriseTradeUserDetailsVo getEnterpriseTradeUserDetails(Integer userid);

    //获取站长用户详情
    StationUserDetailsVo getStationUserDetails(Integer userid);

    //获取站长用户详情
    ExpertUserDetailsVo getExpertUserDetails(Integer userid);

    UserDetailVo getUserDetailByUserId(Integer userId);

    List<UserAndBlocksVo> selectUserAndBlocks();

    /**
     * 获取 种植户 站长 贸易商 专家 数量
     *
     * @return MemberCountVO
     */
    MemberCountVO selectMemberCount();

    List<GrowerDistribute> selectGrowerDistribute();

    //区域排名
    List<AreaRankVo> selectAreaRank();

    List<ActiveCountVo> selectActive();

    User getUser(Integer userId);

    List<TraderDetailYearsPullVO> traderDetailYearsPull(Integer userId);

    TraderPurchaseCompareVO traderPurchaseCompare(TraderPurchaseCompareDTO dto);

    List<Integer> traderIncomeComparePull(Integer userId);

    List<TraderIncomeCompareVO> traderIncomeCompare(TraderIncomeCompareDTO dto);

    StationMembersVO getStationMembers(Integer userId);

    List<StationMemberDistributeVO> getStationMembersDistribute(Integer userId);

    List<AreaUserRankVo> getAreaUserRank(String beginTime, String endTime);

    List<UserDistributionVo> getUserDistribution() throws IOException;
}
