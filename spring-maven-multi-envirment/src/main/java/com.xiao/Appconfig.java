package com.xiao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
    @Value("${profile}")
    public String profile;
}
