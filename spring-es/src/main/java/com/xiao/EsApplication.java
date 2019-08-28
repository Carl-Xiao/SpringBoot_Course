package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
@SpringBootApplication(exclude = {ElasticsearchAutoConfiguration.class})
public class EsApplication {
    public static void main(String[] args) {
        SpringApplication es = new SpringApplication(EsApplication.class);
        es.run(args);
    }
}
