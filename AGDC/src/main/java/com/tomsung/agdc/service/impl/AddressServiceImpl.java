package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.AddressArea;
import com.tomsung.agdc.domain.AddressCity;
import com.tomsung.agdc.domain.AddressProvince;
import com.tomsung.agdc.mapper.AddressAreaMapper;
import com.tomsung.agdc.mapper.AddressCityMapper;
import com.tomsung.agdc.mapper.AddressProvinceMapper;
import com.tomsung.agdc.service.IAddressService;
import com.tomsung.agdc.vo.AddressVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/21 11:18
 * @Description:
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressProvinceMapper addressProvinceMapper;
    @Autowired
    private AddressCityMapper addressCityMapper;
    @Autowired
    private AddressAreaMapper addressAreaMapper;

    @Override
    public List<AddressProvince> listGrowersProvince() {

        List<AddressProvince> list = addressProvinceMapper.selectByAllGrowers();
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<AddressCity> listGrowersCity(String provinceCode) {

        List<AddressCity> list = addressCityMapper.selectGrowersByProvince(provinceCode);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public List<AddressArea> listGrowersArea(String cityCode) {

        List<AddressArea> list = addressAreaMapper.selectGrowersByCity(cityCode);
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }

    @Override
    public AddressVO getAddress(String areaCode) {

        AddressVO vo = addressAreaMapper.selectAddressByCode(areaCode);
        if (vo == null) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return vo;
    }
}
