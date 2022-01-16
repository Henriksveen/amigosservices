package com.amigoscode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {
        "com.amigoscode.customer", // we add com.amigoscode.customer, since we don't get default packages when using scanBasePackages
        "com.amigoscode.amqp"
})
//@EnableEurekaClient
@EnableFeignClients(basePackages = "com.amigoscode.clients")
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
