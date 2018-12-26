package com.tomsung.agdc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.domain.Expert;
import com.tomsung.agdc.domain.ProficientCropKey;
import com.tomsung.agdc.mapper.ExpertMapper;
import com.tomsung.agdc.mapper.ExpertScoreMapper;
import com.tomsung.agdc.mapper.ProficientCropMapper;
import com.tomsung.agdc.mapper.ReplyMapper;
import com.tomsung.agdc.service.IExpertService;
import com.tomsung.agdc.vo.CountVo;
import com.tomsung.agdc.vo.ExpertListItemVO;
import com.tomsung.agdc.vo.MapVo;
import com.tomsung.agdc.vo.RankVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpertServiceImpl implements IExpertService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ExpertMapper expertMapper;
    @Autowired
    ProficientCropMapper proficientCropMapper;
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    ExpertScoreMapper expertScoreMapper;

    @Override
    public List<CountVo> getCountList() {
        List<CountVo> vos = new ArrayList<CountVo>();
        //获取当前时间的前一个月
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();

        //专家总数
        CountVo vo1 = new CountVo();
        vo1.id = 1;
        vo1.count = expertMapper.selectExpertCount(null);
        vo1.monthCount = expertMapper.selectExpertCount(date);
        vos.add(vo1);
        //覆盖区域(按区县)
        CountVo vo2 = new CountVo();
        vo2.id = 2;
        vo2.count = expertMapper.selectDistrictCount();
        vo2.monthCount = expertMapper.selectMonthDistrictCount(date);
        vos.add(vo2);
        //覆盖作物
        CountVo vo3 = new CountVo();
        vo3.id = 3;
        vo3.count = proficientCropMapper.selectCropCount();
        vo3.monthCount = proficientCropMapper.selectMonthCropCount(date);
        vos.add(vo3);
        //解答问题数
        CountVo vo4 = new CountVo();
        vo4.id = 4;
        vo4.count = replyMapper.selectReplyCount(null);
        vo4.monthCount = replyMapper.selectReplyCount(date);
        vos.add(vo4);
        //线下服务次数(TO-DO)
        CountVo vo5 = new CountVo();
        vo5.id = 5;
        vo5.count = 84;
        vo5.monthCount = 34;
        vos.add(vo5);
        //被采纳问题数
        CountVo vo6 = new CountVo();
        vo6.id = 6;
        vo6.count = replyMapper.selectAdoptCount(null);
        vo6.monthCount = replyMapper.selectAdoptCount(date);
        vos.add(vo6);
        //专家被评价次数
        CountVo vo7 = new CountVo();
        vo7.id = 7;
        vo7.count = expertScoreMapper.selectCommitCount(null);
        vo7.monthCount = expertScoreMapper.selectCommitCount(date);
        vos.add(vo7);
        //视频时长(TO-DO)
        CountVo vo8 = new CountVo();
        vo8.id = 8;
        vo8.count = 3113;
        vo8.monthCount = 455;
        vos.add(vo8);
        return vos;
    }

    @Override
    public List<RankVo> getRankList(Integer id) {
        List<RankVo> vos = new ArrayList<RankVo>();
        if (id == 1) {
            //专家活跃度排名
            List<Expert> experts = expertMapper.selectExpertLiveness();
            for (Expert e : experts) {
                RankVo vo = new RankVo();
                vo.setName(e.getRealname());
                vo.setValue(e.getLiveness());
                vos.add(vo);
            }
        } else {
            //专家评分排名
            List<Expert> experts = expertMapper.selectExpertEvalution();
            for (Expert e : experts) {
                RankVo vo = new RankVo();
                vo.setName(e.getRealname());
                vo.setValue(e.getAvg());
                vos.add(vo);
            }
        }
        return vos;
    }

    @Override
    public List<RankVo> getCompositionList() {
        List<RankVo> vos = new ArrayList<RankVo>();
        List<Expert> experts = expertMapper.selectExpertType();
        for (Expert e : experts) {
            RankVo vo = new RankVo();
            vo.setName(e.getExpertType());
            vo.setValue(e.getTypeCount());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<RankVo> getConsistOfCrop() {
        List<RankVo> vos = new ArrayList<RankVo>();
        List<ProficientCropKey> proficientCropKeys = proficientCropMapper.selectConsistOfCrop();
        for (ProficientCropKey p : proficientCropKeys) {
            RankVo vo = new RankVo();
            vo.setName(p.getCrop().getCropName());
            vo.setValue(p.getExpertCount());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<MapVo> getHeatingList() {
        List<MapVo> vos = new ArrayList<MapVo>();
        List<Expert> experts = expertMapper.selectExpertInfoByProvince();
        for (Expert e : experts) {
            MapVo vo = new MapVo();
            vo.name = e.getProvinceName();
            vo.value = new LinkedList<>();
            vo.value.add(0);
            vo.value.add(e.getReplyCountByProvince());
            vo.value.add(vos.size() + 1);
            vo.value.add(e.getExpertCount());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<MapVo> getExpertList() {
        List<MapVo> vos = new ArrayList<MapVo>();
        List<Expert> experts = expertMapper.selectExpertInfo();
        for (Expert e : experts) {
            MapVo vo = new MapVo();
            vo.name = e.getRealname();
            vo.value = new LinkedList<>();
            vo.value.add(e.getAdd_x());
            vo.value.add(e.getAdd_y());
            vo.value.add(e.getExpertType());
            vo.value.add(e.getCropName());
            vo.value.add(e.getCityName() + e.getDistrictName());
            vo.value.add(e.getMobilePhone());
            vo.value.add(e.getAvg());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public PageInfo<ExpertListItemVO> getAllExpertList(int pageNum, int pageSize, String keyword) {
        if (StringUtils.isNotBlank(keyword)) {
            keyword = "%" + keyword + "%";
        }
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ExpertListItemVO> experts = expertMapper.selectList(keyword);
            if (CollectionUtils.isNotEmpty(experts)) {
                return new PageInfo<>(experts);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return new PageInfo<>(new ArrayList<ExpertListItemVO>());
    }

    @Override
    public Expert getExpertDetail(Integer id) {
        Expert expert = expertMapper.selectByPrimaryKey(id);
        return expert;
    }

    @Override
    public List<RankVo> getLivenessList() {
        return expertMapper.selectLivenessTop10();
    }

    @Override
    public List<RankVo> getGradeList() {
        return expertMapper.selectGradeTop10();
    }
}
