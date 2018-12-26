package com.tomsung.agdc.mapper;

import com.tomsung.agdc.domain.User;
import com.tomsung.agdc.dto.TraderIncomeCompareDTO;
import com.tomsung.agdc.dto.TraderPurchaseCompareDTO;
import com.tomsung.agdc.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUser();

    List<User> selectAllActivityUsers();

    //本月新增用户 & 用户总数
    Integer selectUserCount(Date date);

    //合同用户总数
    Integer selectContractCount(Date date);

    //获取每个城市的用户数
    List<User> selectUserCountByCity();

    //获取每个省份的用户数
    List<User> selectUserCountByProvince();

    //用户数排名按省
    List<User> selectUserCountRank(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    //近半年每个月非签约用户数
    Integer selectNoContractCountByTime(Date time);

    //近半年每个月签约用户数
    Integer selectContractCountByTime(Date time);

    Integer selectUserCountByTime(Date time);

    List<User> selectContractUserCountByDistrict(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    //用户在地图上的分布
    List<UserNameAndAddressVo> selectUserNameAndAddress();

    //获取种植户信息列表
    List<FarmerUserVo> selectFarmerUser(@Param("like") String like);

    //获取个人贸易商信息列表
    List<PersonTraderUserVo> selectPersonTraderUserList();

    //获取企业贸易商信息列表
    List<EnterpriseTraderUserVo> selectEnterpriseTraderUserList();

    //获取站长信息列表
    List<StationUserVo> selectStationUserList(@Param("like") String like);

    //获取专家信息列表
    List<ExpertUserVo> selectExpertUserList();

    //获取种植户详情
    FarmerUserDetailsVo selectFarmerUserDetails(Integer userId);

    //获取个人贸易商用户详情
    PersonTraderUserDetailsVo selectPersonTraderUserDetails(Integer userId);

    //获取企业贸易商用户详情
    EnterpriseTradeUserDetailsVo selectEnterpriseTradeUserDetails(@Param("userId") Integer userId);

    //获取站长用户详情
    StationUserDetailsVo selectStationUserDetails(Integer userId);

    //获取专家用户详情
    ExpertUserDetailsVo selectExpertUserDetails(Integer userId);

    UserDetailVo selectUserDetailByUserId(@Param("userId") Integer userId);

    List<UserAndBlocksVo> selectUserAndBlocks();

    MemberCountVO selectMemberCount();


    //获取用户分布及种植详情
    List<GrowerDistribute> selectGrowerDistribute();

    //区域排名
    List<AreaRankVo> selectAreaRank();

    List<ActiveCountVo> userActiveCount();

    List<ActiveCountVo> expertActiveCount();

    /**
     * 使用真实姓名模糊查询种植户
     *
     * @param realName
     * @return
     */
    List<User> selectGrowersLikeRealName(String realName);

    /**
     * 使用区县编号查询种植户信息
     *
     * @param areaCode
     * @return
     */
    List<User> selectGrowersByAreaCode(@Param("areaCode") String areaCode);

    User selectByUserId(Integer userId);

    List<String> selectCropByUserId(@Param("userId") Integer userId);

    List<TraderDetailYearsPullVO> getTraderDetailYearsPull(@Param("userId") Integer userId);

    List<TraderPurchaseCompareVO.InnerClass> getTraderPurchaseCompare(TraderPurchaseCompareDTO dto);

    Integer getSubsidy(@Param("cropId") Integer cropId);

    List<Integer> getTraderIncomeCompare(@Param("userId") Integer userId);

    List<TraderIncomeCompareVO> getGraderIncomeCompare(TraderIncomeCompareDTO dto);

    List<StationMembersVO.InnerClass> getStationMembers(@Param("userId") Integer userId);

    List<StationMemberDistributeVO.InnerClass> getStationMembersDistribute(@Param("userId") Integer userId);

    List<AreaUserRankVo> selectAreaUserRank(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<UserDistributionVo> selectUserDistribution();
}