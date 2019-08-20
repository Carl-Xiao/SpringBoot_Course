package com.xiao;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiaoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MiaoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
