package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Carl-Xiao 2019-08-15
 */
@SpringBootApplication
public class GrpcApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GrpcApplication.class);
        app.setWebEnvironment(true);
        app.run(args);
    }
}
