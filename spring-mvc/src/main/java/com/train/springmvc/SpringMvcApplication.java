package com.train.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

}

