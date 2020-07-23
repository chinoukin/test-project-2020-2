package com.wisea.fbsapp1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages="com.wisea.fbsapp1.dao")
public class FbsApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(FbsApp1Application.class, args);
    }

}
