package com.xiao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Carl-Xiao 2019-08-15
 */
public class Car {
    private final static Logger logger = LoggerFactory.getLogger(Car.class);

    public void printName() {
        logger.info("这是一辆测试车~");
    }

}
