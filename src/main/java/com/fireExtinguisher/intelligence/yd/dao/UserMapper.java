package com.fireExtinguisher.intelligence.yd.dao;

import com.fireExtinguisher.intelligence.yd.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> select(@Param("username") String username);
}
