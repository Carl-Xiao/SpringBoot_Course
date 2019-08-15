package com.xiao.controller;

import com.xiao.Car;
import com.xiao.annontion.AopMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Carl-Xiao 2019-08-15
 */
@RestController
public class AopController {

    @Autowired
    Car car;


    @GetMapping(value = "/sayHello")
    @AopMethod
    public String sayHello() {
        return "hello world";
    }

    @GetMapping(value = "/sayPython")
    public String sayPython(HttpServletRequest request) {

        String token = request.getHeader("token");
        System.out.println("getToken===========" + token);

        car.printName();
        return "hello python";
    }

}
