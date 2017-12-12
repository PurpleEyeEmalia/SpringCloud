package com.yrzy.springcloudzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Copyright (c) 2017-2018 Wuhan Yryz Network Company LTD.
 * All rights reserved.
 *
 * @Description:
 * @Date: Created in 2017 2017/12/12 14:23
 * @Author: pn
 */
@Component
public class MyFilter extends ZuulFilter {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        LOGGER.info("start verify access token !!!");
        if (StringUtils.isBlank(token)) {
            LOGGER.warn("token is empty!");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("token is empty!!!");
            } catch (IOException e) {
                LOGGER.error("response write IOException!");
            }
            return null;
        }
        LOGGER.info("verify ok !");
        return null;
    }
}
