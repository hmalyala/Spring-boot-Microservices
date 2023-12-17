package com.org.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.org.clients"
)
public class CustomerApplication {

    public static void main(String[] args){
        SpringApplication.run(CustomerApplication.class, args);
    }
}
