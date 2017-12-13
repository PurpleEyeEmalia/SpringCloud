package com.yryz.springcloudzipkinserviceemilia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringCloudZipkinServiceEmiliaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZipkinServiceEmiliaApplication.class, args);
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudZipkinServiceEmiliaApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String hi() {
        LOGGER.info("hi is being called");
        return "hi i'm emilia!!!";
    }

    @RequestMapping("/emilia")
    public String emilia() {
        LOGGER.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

}
