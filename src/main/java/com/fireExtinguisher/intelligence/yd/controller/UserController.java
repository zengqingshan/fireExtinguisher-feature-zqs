package com.fireExtinguisher.intelligence.yd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.fireExtinguisher.intelligence.yd.entity.User;
import com.fireExtinguisher.intelligence.yd.param.UserParam;
import com.fireExtinguisher.intelligence.yd.service.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping("/select")
    PageInfo<User> select(@RequestBody UserParam userParam){
        log.info(userParam.getUsername(), userParam);
        return userService.select(userParam);
    }
}
