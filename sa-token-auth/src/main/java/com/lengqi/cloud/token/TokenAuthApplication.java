package com.lengqi.cloud.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TokenAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenAuthApplication.class, args);
    }

}
