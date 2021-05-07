package com.lengqi.cloud.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.lengqi.cloud.admin.feign")
public class TokenAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenAuthApplication.class, args);
    }

}
