package com.tomsung.agdc.service.impl;

import com.tomsung.agdc.common.ResultStatus;
import com.tomsung.agdc.common.ServiceException;
import com.tomsung.agdc.domain.UserMatter;
import com.tomsung.agdc.mapper.UserMatterMapper;
import com.tomsung.agdc.service.IUserMatterService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangqi
 * @Date: 2018/9/11 9:45
 * @Description:
 */
@Service
public class UserMatterServiceImpl implements IUserMatterService {

    @Autowired
    private UserMatterMapper userMatterMapper;

    @Override
    public List<UserMatter> listAll() {

        List<UserMatter> list = userMatterMapper.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultStatus.NO_DATA);
        }

        return list;
    }
}
