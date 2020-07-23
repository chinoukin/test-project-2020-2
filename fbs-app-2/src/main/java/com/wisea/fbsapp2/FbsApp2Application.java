package com.wisea.fbsapp2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan(basePackages="com.wisea.fbsapp2.dao")
public class FbsApp2Application {

    public static void main(String[] args) {
        SpringApplication.run(FbsApp2Application.class, args);
    }

}
