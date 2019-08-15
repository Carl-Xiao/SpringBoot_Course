package com.xiao;

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

    @GetMapping
    public String environment(){
        return environment;
    }

}
