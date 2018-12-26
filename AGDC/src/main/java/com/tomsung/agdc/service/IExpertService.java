package com.tomsung.agdc.service;

import com.github.pagehelper.PageInfo;
import com.tomsung.agdc.domain.Expert;
import com.tomsung.agdc.vo.*;

import java.util.List;

public interface IExpertService {

    List<CountVo> getCountList();

    List<RankVo> getRankList(Integer id);

    List<RankVo> getCompositionList();

    List<RankVo> getConsistOfCrop();

    List<MapVo> getHeatingList();

    List<MapVo> getExpertList();

    PageInfo<ExpertListItemVO> getAllExpertList(int PageNum, int PageSize, String keyword);

    Expert getExpertDetail(Integer id);

    List<RankVo> getLivenessList();

    List<RankVo> getGradeList();
}
