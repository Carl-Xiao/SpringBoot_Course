package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsApplication {
    public static void main(String[] args) {
        SpringApplication es = new SpringApplication(EsApplication.class);
        es.run(args);
    }
}
