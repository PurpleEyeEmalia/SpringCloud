package com.yryz.springcloudfeign;

import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2017 2017/12/12 13:48
 * @Author: pn
 */
@Component
public class FeignFallBackService implements FeignServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "hi," + name + ",this is a feign error page!";
    }
}
