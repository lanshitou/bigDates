package com.tomsung.agdc.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.tomsung.agdc.domain.PickupPoint;

@Mapper
@Component
public interface PickupPointMapper {
    int selectPickupCount(Date date);
}