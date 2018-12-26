package com.tomsung.agdc.service;

import com.tomsung.agdc.domain.AddressArea;
import com.tomsung.agdc.domain.AddressCity;
import com.tomsung.agdc.domain.AddressProvince;
import com.tomsung.agdc.vo.AddressVO;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/21 11:18
 * @Description:
 */
public interface IAddressService {

    List<AddressProvince> listGrowersProvince();

    List<AddressCity> listGrowersCity(String provinceCode);

    List<AddressArea> listGrowersArea(String cityCode);

    AddressVO getAddress(String areaCode);

}
