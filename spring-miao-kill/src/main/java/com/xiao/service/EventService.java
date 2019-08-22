package com.xiao.service;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final static Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    RedissonClient singleClient;

    public void processEvent(String key) {
        StringCodec codec = new StringCodec();
        RBlockingQueue<String> blockQueue = singleClient.getBlockingQueue(key, codec);
        try {
            String value = blockQueue.take();
            logger.info("获取值" + value + "==处理业务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
