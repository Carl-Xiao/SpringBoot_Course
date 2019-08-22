package com.xiao.service;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDeque;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SecKillService {
    private final static Logger logger = LoggerFactory.getLogger(SecKillService.class);

    @Autowired
    RedissonClient singleClient;

    public void generateToken() {
        //1 秒杀商品的ID作为Key 生成结果为List
        String key = "miao_kill";
        StringCodec codec = new StringCodec();
        RDeque rDeque = singleClient.getDeque(key, codec);
        for (int i = 0; i < 100; i++) {
            rDeque.addFirst("miao_" + i);
        }
    }

    /**
     * 消费生成的Token
     */
    public void consumeGenerateToken() {
        StringCodec codec = new StringCodec();
        RBlockingQueue<String> blockQueue = singleClient.getBlockingQueue("miao_kill", codec);
        try {
            String value = blockQueue.take();
            logger.info("获取值" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
