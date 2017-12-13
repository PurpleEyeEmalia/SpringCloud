package com.yryz.springcloudzipkinservicehi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringCloudZipkinServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZipkinServiceHiApplication.class, args);
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudZipkinServiceHiApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler getAlwaysSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping("/hi")
    public String getHi() {
        LOGGER.info("calling trace zipkin service hi !");
        return restTemplate.getForObject("http://localhost:8989/hi", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        LOGGER.info("calling trace zipkin service hi");
        return "I'm zipkin service hi";
    }

}
