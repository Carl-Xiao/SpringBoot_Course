package com.xiao;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl-Xiao 2019-08-15
 */
@RestController
public class EnviormentController {
    @Value("${name}")
    public String environment;

    @Autowired
    RedissonClient singleClient;

    @GetMapping
    public String environment() {
        return environment;
    }

    @GetMapping(value = "/testClient")
    public String testClient() {
        System.out.println("testClient=================================");

        RBucket<String> bucket = singleClient.getBucket("hello");
        bucket.set("one");

        String value = bucket.get();
        return value;
    }
}
