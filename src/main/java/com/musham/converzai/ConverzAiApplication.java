package com.musham.converzai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ConverzAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConverzAiApplication.class, args);
    }

}
