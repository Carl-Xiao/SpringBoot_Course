package com.xiao.controller;

import com.xiao.dao.SecKillDao;
import com.xiao.event.HelloEvent;
import com.xiao.service.SecKillService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    /**
     * 生成商品等同数量令牌,用redis去控制频繁对数据库的IO读写操作
     */
    @GetMapping(value = "generateToken")
    public void generateToken() {
        secKillService.generateToken();
    }

    @GetMapping(value = "consumeGenerateToken")
    public void consumeGenerateToken() {
        //控制获取令牌桶的速率
        //redis锁 显示用户的请求时间
        RLock rLock = singleClient.getLock("sec_kill+用户ID");
        //10s后自动解锁
        boolean isLocked = rLock.isLocked();
        if(isLocked){
            //返回错误提示信息
        }else {
            rLock.lock(10, TimeUnit.SECONDS);
        }
        //真正的业务处理逻辑
        applicationContext.publishEvent(new HelloEvent("miao_kill"));
    }

}
