package com.xiao.controller;

import com.xiao.dao.SecKillDao;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    public SecKillDao secKillDao;

    @Autowired
    RedissonClient singleClient;

    @GetMapping
    public String hello() {
        return secKillDao.getVersion();
    }
    @GetMapping(value = "/killversion")
    public void killVersion() {
        String version = secKillDao.getVersion();
        int result = secKillDao.updateStoreByVersion(version);
        if (result == 1) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    @GetMapping(value = "/version")
    public String getVersion() {
        return secKillDao.getVersion();
    }

}
