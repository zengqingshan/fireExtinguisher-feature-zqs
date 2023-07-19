package com.fireExtinguisher.intelligence.yd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.fireExtinguisher.intelligence.yd.dao.UserMapper;
import com.fireExtinguisher.intelligence.yd.entity.User;
import com.fireExtinguisher.intelligence.yd.param.UserParam;
import com.fireExtinguisher.intelligence.yd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo<User> select(UserParam userParam) {

        // 先进行分页；
        PageHelper.startPage(userParam.getPageNum(), userParam.getPageSize());
        List<User> list = userMapper.select(userParam.getUsername());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
