package com.fireExtinguisher.intelligence.yd.service;

import com.github.pagehelper.PageInfo;
import com.fireExtinguisher.intelligence.yd.entity.User;
import com.fireExtinguisher.intelligence.yd.param.UserParam;

public interface UserService {
    PageInfo<User> select(UserParam userParam);
}
