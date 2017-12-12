package com.yryz.springcloudfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2017 2017/12/11 20:50
 * @Author: pn
 */
@RestController
public class FeignController {

    @Autowired
    private FeignServiceHi feignServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam String name) {
        return feignServiceHi.sayHiFromClientOne(name);
    }

}
