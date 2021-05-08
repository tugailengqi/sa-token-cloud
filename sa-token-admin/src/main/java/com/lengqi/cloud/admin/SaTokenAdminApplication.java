package com.lengqi.cloud.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lengqi.cloud.admin.mapper")
public class SaTokenAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaTokenAdminApplication.class,args);
    }
}
