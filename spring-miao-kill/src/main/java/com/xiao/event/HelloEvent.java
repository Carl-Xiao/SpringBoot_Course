package com.xiao.event;

import org.springframework.context.ApplicationEvent;

public class HelloEvent extends ApplicationEvent {
    public HelloEvent(String key) {
        super(key);
    }
}
