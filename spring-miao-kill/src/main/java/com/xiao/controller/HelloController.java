package com.xiao.controller;

import com.xiao.dao.SecKillDao;
import com.xiao.event.HelloEvent;
import com.xiao.service.SecKillService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    public SecKillDao secKillDao;

    @Autowired
    public SecKillService secKillService;

    @Autowired
    RedissonClient singleClient;

    @Autowired
    ApplicationContext applicationContext;

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

    @GetMapping(value = "generateToken")
    public void generateToken() {
        secKillService.generateToken();
    }

    @GetMapping(value = "consumeGenerateToken")
    public void consumeGenerateToken() {
        applicationContext.publishEvent(new HelloEvent("miao_kill"));
    }

}
