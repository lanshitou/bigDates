package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.common.Constants;
import com.tomsung.agdc.domain.CropGrow;
import com.tomsung.agdc.mapper.CropGrowMapper;
import com.tomsung.agdc.service.ICropService;
import com.tomsung.agdc.vo.CropCountVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CropServiceImpl implements ICropService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CropGrowMapper cropGrowMapper;

    @Override
    public List<CropCountVO> getCropCountVO() {
        List<CropCountVO> cropCountVOS = cropGrowMapper.selectCropCountVO();
        final BigDecimal[] total = {new BigDecimal("0")};
        final BigDecimal[] percentBefore = {new BigDecimal("0")};

        cropCountVOS.forEach(a -> {
            total[0] = total[0].add(a.getArea());
        });
        cropCountVOS.forEach(a -> {
            a.setPercent(a.getArea().divide(total[0], 4, BigDecimal.ROUND_DOWN).movePointRight(2));
        });
        cropCountVOS.forEach(a -> {
            if (cropCountVOS.get(cropCountVOS.size() - 1).equals(a)) {
                a.setPercent(new BigDecimal(100).subtract(percentBefore[0]));
            } else {
                percentBefore[0] = percentBefore[0].add(a.getPercent());
            }
        });

        return cropCountVOS;
    }

    @Override
    public String getCropGrowStepName(List<CropGrow> cropGrows, Date plantTIme) {
        if (CollectionUtils.isEmpty(cropGrows) || plantTIme == null) {
            return "";
        }
        int daysBetween = (int) (new Date().getTime() - plantTIme.getTime()) / (24 * 60 * 60 * 1000);
        final int[] daysCount = {0};
        final String[] returnString = {null};
        cropGrows.forEach(a -> {
            int temp = daysCount[0] + a.getStageDays();
            if (daysCount[0] <= daysBetween && daysBetween <= temp) {
                returnString[0] = a.getName();
            }
        });
        if (returnString[0] == null) {
            returnString[0] = Constants.HAS_BEEN_GAIN;
        }

        return returnString[0];
    }
}
