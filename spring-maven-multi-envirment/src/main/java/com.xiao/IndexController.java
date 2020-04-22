package com.xiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    Appconfig appconfig;

    @RequestMapping("/")
    public String profile() {
        return appconfig.profile;
    }


}
