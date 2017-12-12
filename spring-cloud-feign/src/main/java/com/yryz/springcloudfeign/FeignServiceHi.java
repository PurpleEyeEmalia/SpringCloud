package com.yryz.springcloudfeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2017 2017/12/11 20:48
 * @Author: pn
 */
@FeignClient(value = "service-hi", fallback = FeignFallBackService.class)
public interface FeignServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
