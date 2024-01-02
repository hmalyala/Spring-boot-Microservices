package com.org.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.org.clients"
)
@PropertySources(
        @PropertySource("classpath:client-${spring.profiles.active}.properties")
)
public class CustomerApplication {

    public static void main(String[] args){
        SpringApplication.run(CustomerApplication.class, args);
    }
}
