package com.tomsung.agdc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.google.common.base.Joiner;
import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.Expert;
import com.tomsung.agdc.domain.SaleDetail;
import com.tomsung.agdc.domain.User;
import com.tomsung.agdc.dto.TraderIncomeCompareDTO;
import com.tomsung.agdc.dto.TraderPurchaseCompareDTO;
import com.tomsung.agdc.mapper.*;
import com.tomsung.agdc.service.IUserService;
import com.tomsung.agdc.util.GetLatAndLngByBaidu;
import com.tomsung.agdc.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserMapper userMapper;
    @Autowired
    OperateLogMapper operateLogMapper;
    @Autowired
    SaleDetailMapper saleDetailMapper;
    @Autowired
    ExpertMapper expertMapper;
    @Autowired
    CropServiceImpl cropService;
    @Autowired
    BlockMapper blockMapper;

    @Override
    public PageInfo<User> getUserList(int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> users = userMapper.selectAllUser();
            if (CollectionUtils.isNotEmpty(users)) {
                return new PageInfo<>(users);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<User>());
    }

    @Override
    public PageInfo<SaleDetail> getZhxnUserDetail(Integer userId, int pageNum, int pageSize) {

        try {
            PageHelper.startPage(pageNum, pageSize);
            List<SaleDetail> saleDetails = saleDetailMapper.selectSaleDetailsByUser(userId);
            return new PageInfo<>(saleDetails);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<SaleDetail>());
    }

    @Override
    public List<ActivityUserVo> getAllActivityUserList(int pageNum, int pageSize) {
        List<ActivityUserVo> aUsers = new ArrayList<ActivityUserVo>();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> users = userMapper.selectAllActivityUsers();
            if (CollectionUtils.isNotEmpty(users)) {
                aUsers = processActivityUserData(users);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return aUsers;
    }

    @Override
    public List<CountVo> getCountList() {
        List<CountVo> vos = new ArrayList<CountVo>();
        //获取当前时间的前一个月
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();

        //注册用户总数
        CountVo vos1 = new CountVo();
        vos1.id = 1;
        vos1.count = userMapper.selectUserCount(null);
        vos1.monthCount = userMapper.selectUserCount(date);
        vos.add(vos1);
        //签约用户总数
        CountVo vos2 = new CountVo();
        vos2.id = 2;
        vos2.count = userMapper.selectContractCount(null);
        vos2.monthCount = userMapper.selectContractCount(date);
        vos.add(vos2);
        //活跃用户总数
        CountVo vos3 = new CountVo();
        vos3.id = 3;
        vos3.count = operateLogMapper.selectActivityCount(null);
        vos3.monthCount = operateLogMapper.selectActivityCount(date);
        vos.add(vos3);
        //农业大户
        //TO-DO
        CountVo vos4 = new CountVo();
        vos4.id = 4;
        vos4.count = 122;
        vos4.monthCount = 23;
        vos.add(vos4);
        return vos;
    }

    @Override
    public List<MapVo> getUserMapSpread() {
        List<MapVo> vos = new ArrayList<MapVo>();
        List<User> users = userMapper.selectUserCountByCity();
        for (User u : users) {
            MapVo vo = new MapVo();
            vo.name = u.getCityName();
            vo.value = new LinkedList<>();
            vo.value.add(u.getAddY());
            vo.value.add(u.getAddX());
            vo.value.add(u.getTotalCount());
            vo.value.add(u.getContractCount());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<RankVo> getUserCountRank(Date beginTime, Date endTime) {
        List<RankVo> vos = new ArrayList<>();
        List<User> users = userMapper.selectUserCountRank(beginTime, endTime);
        for (User u : users) {
            RankVo vo = new RankVo();
            vo.setName(u.getProvinceName());
            vo.setValue(u.getCountByProvince());
            vos.add(vo);
        }
        return vos;
    }

    public List<MapVo> getContractUserCountList(Date beginTime, Date endTime) {
        //传进来时间段,则按时间段,没有的话默认近半年
        if (beginTime != null || endTime != null) {
            //计算时间间隔
            long time1 = beginTime.getTime();
            long time2 = endTime.getTime();
            long day = (time2 - time1) / (1000 * 3600 * 24);
            List<MapVo> countList = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            int count = 0;
            //时间间隔小于30天,每2天一个点
            if (day < Constants.ONE_MONTH) {
                while (count <= day) {
                    count += 2;
                    MapVo vo = new MapVo();
                    vo.name = (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH + calendar.get(Calendar.DAY_OF_MONTH) + Constants.DAY;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectNoContractCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.DAY_OF_MONTH, -2);
                }
                //时间间隔小于90天,每7天一个点
            } else if (day < Constants.THREE_MONTH) {
                while (count <= day) {
                    count += 7;
                    MapVo vo = new MapVo();
                    vo.name = (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH + calendar.get(Calendar.DAY_OF_MONTH) + Constants.DAY;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectNoContractCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                }
                //时间间隔小于一年半,每个月一个点
            } else if (day < Constants.ONE_HALF_YEAR) {
                while (count <= day) {
                    count += 30;
                    MapVo vo = new MapVo();
                    vo.name = calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectNoContractCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.MONTH, -1);
                }
            } else {
                //大于一年的每年一个点
                while (count <= day) {
                    count += 365;
                    MapVo vo = new MapVo();
                    vo.name = calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                    list.add(userMapper.selectNoContractCountByTime(calendar.getTime()));
                    vo.value = list;
                    countList.add(vo);
                    calendar.add(Calendar.YEAR, -1);
                }
            }
            Collections.reverse(countList);
            return countList;
        } else {
            List<MapVo> countList = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();
            for (int i = 1; i <= Constants.FORMONTH; i++) {
                MapVo vo = new MapVo();
                vo.name = calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH;
                List<Integer> list = new ArrayList<Integer>();
                list.add(userMapper.selectContractCountByTime(calendar.getTime()));
                list.add(userMapper.selectNoContractCountByTime(calendar.getTime()));
                vo.value = list;
                countList.add(vo);
                calendar.add(Calendar.MONTH, -1);
            }
            Collections.reverse(countList);
            return countList;
        }
    }

    @Override
    public List<MapVo> getUserLiveness() {
        List<MapVo> liveness = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= Constants.FORMONTH; i++) {
            MapVo vo = new MapVo();
            vo.name = calendar.get(Calendar.YEAR) + Constants.YEAR + (calendar.get(Calendar.MONTH) + 1) + Constants.MONTH;
            List<Integer> list = new ArrayList<Integer>();
            list.add(operateLogMapper.selectContractLiveness(calendar.getTime()));
            list.add(operateLogMapper.selectNoContractLiveness(calendar.getTime()));
            vo.value = list;
            liveness.add(vo);
            calendar.add(Calendar.MONTH, -1);
        }
        Collections.reverse(liveness);
        return liveness;
    }

    @Override
    public List<RankVo> getYieldRank() {
        List<RankVo> rankVos = blockMapper.selectContractUserYield();
        return rankVos;
    }

    private List<ActivityUserVo> processActivityUserData(List<User> users) {
        List<ActivityUserVo> vos = new ArrayList<ActivityUserVo>();
        for (User u : users) {
            ActivityUserVo vo = new ActivityUserVo();
            vos.add(vo);
            vo.userName = u.getUsername();
            vo.provinceName = u.getPrivinceName();
            vo.cityName = u.getCityName();
            vo.districtName = u.getDistrictName();
            vo.address = u.getAddress();
            vo.questionNum = u.getQuestionReplyRecord().getQuestionCount();
        }
        return vos;
    }

    @Override
    public List<RankVo> getContractUserCountRank(Date beginTime, Date endTime) {
        List<RankVo> vos = new ArrayList<>();
        List<User> users = userMapper.selectContractUserCountByDistrict(beginTime, endTime);
        for (User u : users) {
            RankVo vo = new RankVo();
            vo.setName(u.getDistrictName());
            vo.setValue(u.getConCount());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public int updateLongtitude() {
        List<Expert> experts = expertMapper.selectExpertInfo();
        int res = 0;
        for (Expert e : experts) {

            String str = e.getProvinceName() + e.getCityName() + e.getDistrictName() + e.getAddress();
            try {
                res = expertMapper.updateLongtitude(e.getId(), GetLatAndLngByBaidu.getCoordinate(str)[0], GetLatAndLngByBaidu.getCoordinate(str)[1]);
            } catch (IOException e1) {
                logger.error(e1.getMessage(), e1);
            }
        }
        return res;
    }

    @Override
    public List<UserNameAndAddressVo> getUserNameAndAddressList() {
        List<UserNameAndAddressVo> userNameAndAddressVos = userMapper.selectUserNameAndAddress();
        return userNameAndAddressVos;
    }

    /**
     * 获取种植户信息列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<FarmerUserVo> getFarmerUserList(int pageNum, int pageSize, String like) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<FarmerUserVo> farmerUserVos = userMapper.selectFarmerUser(like);
            if (CollectionUtils.isNotEmpty(farmerUserVos)) {
                return new PageInfo<>(farmerUserVos);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<FarmerUserVo>());
    }

    /**
     * 获取个人贸易商信息列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Object getTraderUserList(Integer type, int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List resData = new ArrayList<>();
            if (type == 0) {
                resData = userMapper.selectPersonTraderUserList();
            } else {
                List<EnterpriseTraderUserVo> enterpriseTraderUserVos = userMapper.selectEnterpriseTraderUserList();
                for (EnterpriseTraderUserVo enterpriseTraderUserVo : enterpriseTraderUserVos) {
                    List<String> cropNames = userMapper.selectCropByUserId(enterpriseTraderUserVo.getUserId());
                    Joiner on = Joiner.on(",");
                    enterpriseTraderUserVo.setCropName(on.skipNulls().join(cropNames));
                }
                resData = enterpriseTraderUserVos;
            }
            if (CollectionUtils.isNotEmpty(resData)) {
                return new PageInfo<Object>(resData);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<>());
    }

    /**
     * 获取站长信息列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StationUserVo> getStationUserList(int pageNum, int pageSize, String like) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<StationUserVo> stationUserVos = userMapper.selectStationUserList(like);
            if (CollectionUtils.isNotEmpty(stationUserVos)) {
                return new PageInfo<>(stationUserVos);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<StationUserVo>());
    }

    /**
     * 获取专家信息列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ExpertUserVo> getExpertUserList(int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ExpertUserVo> expertUserVos = userMapper.selectExpertUserList();
            if (CollectionUtils.isNotEmpty(expertUserVos)) {
                for (ExpertUserVo expertUserVo : expertUserVos) {
                    if (expertUserVo.getVip() == 39) {
                        expertUserVo.setVip(1);
                    } else {
                        expertUserVo.setVip(0);
                    }
                }
                return new PageInfo<>(expertUserVos);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<ExpertUserVo>());
    }

    /**
     * 获取种植户详情
     *
     * @param userId
     * @return
     */
    @Override
    public FarmerUserDetailsVo getFarmerUserDetails(Integer userId) {
        return userMapper.selectFarmerUserDetails(userId);
    }

    /**
     * 获取个人贸易商用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public PersonTraderUserDetailsVo getPersonTraderUserDetails(Integer userId) {
        PersonTraderUserDetailsVo personTraderUserDetailsVo = userMapper.selectPersonTraderUserDetails(userId);
        if (personTraderUserDetailsVo.getCropName() != null) {
            String[] split = personTraderUserDetailsVo.getCropName().split(",");
            Set<String> objects = new HashSet<>(Arrays.asList(split));
            Joiner on = Joiner.on(",");
            personTraderUserDetailsVo.setCropName(on.skipNulls().join(objects));
        }
        return personTraderUserDetailsVo;
    }

    /**
     * 获取站长用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public StationUserDetailsVo getStationUserDetails(Integer userId) {
        return userMapper.selectStationUserDetails(userId);
    }

    /**
     * 获取专家用户详情
     *
     * @param userId
     * @return
     */
    @Override
    public ExpertUserDetailsVo getExpertUserDetails(Integer userId) {
        return userMapper.selectExpertUserDetails(userId);
    }

    @Override
    public UserDetailVo getUserDetailByUserId(Integer userId) {
        try {
            UserDetailVo userDetailVo = userMapper.selectUserDetailByUserId(userId);
            if (userDetailVo != null) {
                return userDetailVo;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new UserDetailVo();
    }

    @Override
    public List<UserAndBlocksVo> selectUserAndBlocks() {
        List<UserAndBlocksVo> userAndBlocksVos = new ArrayList<>();
        try {
            userAndBlocksVos = userMapper.selectUserAndBlocks();
            if (CollectionUtils.isNotEmpty(userAndBlocksVos)) {
                return new ArrayList<>(userAndBlocksVos);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new ArrayList<>(userAndBlocksVos);
    }

    @Override
    public MemberCountVO selectMemberCount() {
        return userMapper.selectMemberCount();
    }

    @Override
    public List<AreaRankVo> selectAreaRank() {
        return userMapper.selectAreaRank();
    }

    @Override
    public List<GrowerDistribute> selectGrowerDistribute() {
        List<GrowerDistribute> growerDistributes = userMapper.selectGrowerDistribute();
        growerDistributes.forEach(a -> {
            if (a.getDetails() == null) {
                return;
            }
            if (a.getDetails().size() > 3) {
                a.setDetails(a.getDetails().subList(0, 3));
            }
            a.getDetails().forEach(b -> b.setPeriodName(cropService.getCropGrowStepName(b.getCropGrows(), b.getSproutTime())));
            List<String> info = new ArrayList<>();
            a.getDetails().forEach(b -> info.add(b.getPlantName() + " " + b.getArea() + Constants.MU + " " + b.getPeriodName()));
            a.setInfo(info);
        });
        return growerDistributes;
    }

    @Override
    public List<ActiveCountVo> selectActive() {
        List<String> timeList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        for (int i = 5; i >= 0; i--) {
            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, -i);
            Date time = calendar.getTime();
            timeList.add(sdf.format(time));
        }
        List<ActiveCountVo> activeCounts = new ArrayList<>();
        for (String date : timeList) {
            ActiveCountVo activeCountVo = new ActiveCountVo();
            activeCountVo.setTime(date);
            for (ActiveCountVo userCountVo : userMapper.userActiveCount()) {
                if (date.equals(userCountVo.getTime())) {
                    activeCountVo.setUserCount(userCountVo.getUserCount());
                }
            }
            for (ActiveCountVo expertCountVo : userMapper.expertActiveCount()) {
                if (date.equals(expertCountVo.getTime())) {
                    activeCountVo.setExpertCount(expertCountVo.getExpertCount());
                }
            }
            activeCounts.add(activeCountVo);
        }
        return activeCounts;
    }

    @Override
    public User getUser(Integer userId) {

        User user = userMapper.selectByUserId(userId);
        if (user == null) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return user;
    }

    @Override
    public List<TraderDetailYearsPullVO> traderDetailYearsPull(Integer userId) {
        return userMapper.getTraderDetailYearsPull(userId);
    }

    @Override
    public TraderPurchaseCompareVO traderPurchaseCompare(TraderPurchaseCompareDTO dto) {
        if (dto.getStartYear().compareTo(dto.getEndYear()) > 0) {
            Integer temp = dto.getStartYear();
            dto.setStartYear(dto.getEndYear());
            dto.setEndYear(temp);
        }

        TraderPurchaseCompareVO vo = new TraderPurchaseCompareVO();
        List<TraderPurchaseCompareVO.InnerClass> list = userMapper.getTraderPurchaseCompare(dto);
        vo.setDetail(list);
        vo.setSubsidy(new BigDecimal(userMapper.getSubsidy(dto.getCropId())).divide(new BigDecimal(1000), 3, BigDecimal.ROUND_HALF_UP));
        return vo;
    }

    @Override
    public List<Integer> traderIncomeComparePull(Integer userId) {
        return userMapper.getTraderIncomeCompare(userId);
    }

    @Override
    public List<TraderIncomeCompareVO> traderIncomeCompare(TraderIncomeCompareDTO dto) {
        if (dto.getStartYear() > dto.getEndYear()) {
            Integer temp = dto.getStartYear();
            dto.setStartYear(dto.getEndYear());
            dto.setEndYear(temp);
        }
        return userMapper.getGraderIncomeCompare(dto);
    }

    @Override
    public StationMembersVO getStationMembers(Integer userId) {
        StationMembersVO vo = new StationMembersVO();
        List<StationMembersVO.InnerClass> stationMembers = userMapper.getStationMembers(userId);
        vo.setInner(stationMembers);
        BigDecimal[] totalLoan = {new BigDecimal(0)};
        stationMembers.forEach(a -> {
            if (a.getLoanMoney() != null) {
                totalLoan[0] = totalLoan[0].add(a.getLoanMoney());
            }
        });
        vo.setTotalLoanMoney(totalLoan[0]);
        return vo;
    }

    @Override
    public List<StationMemberDistributeVO> getStationMembersDistribute(Integer userId) {
        List<StationMemberDistributeVO> vos = new ArrayList<>();
        List<StationMemberDistributeVO.InnerClass> inners = userMapper.getStationMembersDistribute(userId);
        //应前端要求 包装格式
        inners.forEach(a -> {
            StationMemberDistributeVO vo = new StationMemberDistributeVO();
            vo.setName(a.getUserName());
            List<Object> value = new ArrayList<>();
            value.add(a.getGpsX());
            value.add(a.getGpsY());
            value.add(a.getProvince());
            value.add(a.getCity());
            value.add(a.getDistrict());
            value.add(a.getUserId());
            value.add(a.getUserName());
            value.add(a.getPlantArea());
            vo.setValue(value);
            vos.add(vo);
        });
        return vos;
    }

    @Override
    public List<AreaUserRankVo> getAreaUserRank(String beginTime, String endTime) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = null;
        Date newDate = null;
        List<AreaUserRankVo> areaUserRankVos = null;
        if (StringUtil.isEmpty(beginTime)) {
            now = new Date();
            newDate = stepMonth(now, -6);
            areaUserRankVos = userMapper.selectAreaUserRank(sdf.format(now), sdf.format(newDate));
        } else {
            areaUserRankVos = userMapper.selectAreaUserRank(beginTime, endTime);
        }
        return areaUserRankVos;
    }

    @Override
    public List<UserDistributionVo> getUserDistribution() throws IOException {
        List<UserDistributionVo> userDistributionVos = userMapper.selectUserDistribution();
        for (UserDistributionVo userDistributionVo : userDistributionVos) {
            if (userDistributionVo.getAddress() != null) {
                Object[] coordinate = GetLatAndLngByBaidu.getCoordinate(userDistributionVo.getAddress());
                userDistributionVo.setAddX((String) coordinate[0]);
                userDistributionVo.setAddY((String) coordinate[1]);
            }
        }
        return userDistributionVos;
    }

    /**
     * 企业贸易商详情
     *
     * @param userid
     * @return
     */
    @Override
    public EnterpriseTradeUserDetailsVo getEnterpriseTradeUserDetails(Integer userid) {
        EnterpriseTradeUserDetailsVo enterpriseTradeUserDetailsVo = userMapper.selectEnterpriseTradeUserDetails(userid);
        String cropNames = enterpriseTradeUserDetailsVo.getCropNames();
        if (cropNames != null) {
            String[] split = enterpriseTradeUserDetailsVo.getCropNames().split(",");
            Set<String> hashSet = new HashSet<>();
            for (String s : split) {
                hashSet.add(s);
            }
            Joiner on = Joiner.on(",");
            enterpriseTradeUserDetailsVo.setCropNames(on.skipNulls().join(hashSet));
        }
        return enterpriseTradeUserDetailsVo;
    }

    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);

        return c.getTime();
    }
}
