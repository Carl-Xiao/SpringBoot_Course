package com.xiao;

import com.xiao.annontion.HighAopMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Carl-Xiao 2019-08-14
 */
@SpringBootApplication
@HighAopMethod
public class AopApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AopApplication.class);
        app.setWebEnvironment(true);
        app.run(args);
    }

}
