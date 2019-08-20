package com.xiao.controller;

import com.xiao.dao.SecKillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    public SecKillDao secKillDao;

    @GetMapping
    public String hello() {
        return secKillDao.getVersion();
    }

    @GetMapping(value = "/version")
    public String helloVersion() {
        return secKillDao.getVersion();
    }


}
