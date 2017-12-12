package com.yryz.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

    @Value("${foo}")
    private String foo;

    @Value("${democonfigclient.message}")
    private String democonfigclientMessage;

    @RequestMapping("/hi")
    public String hi() {
        return foo;
    }

    @RequestMapping("/hello")
    public String hello() {
        return democonfigclientMessage;
    }
}
