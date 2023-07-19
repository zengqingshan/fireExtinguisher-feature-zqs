package com.fireExtinguisher.intelligence.yd.param;

import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
public class UserParam {

    private Integer pageNum = 1;

    private Integer pageSize = 3;
    private String username;
}
