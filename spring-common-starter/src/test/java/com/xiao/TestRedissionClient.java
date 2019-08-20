package com.xiao;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

/**
 * @author Carl-Xiao 2019-08-19
 */

public class TestRedissionClient {
    public static void main(String[] args) {
        Config config = new Config();
        String redisAddress = "redis://127.0.0.1:6379";
        config.useSingleServer()
                .setAddress(redisAddress)
                .setDatabase(0)
                .setKeepAlive(true)
                .setPingConnectionInterval(1000);
        RedissonClient redisson = Redisson.create(config);

        StringCodec fastcode = new StringCodec();

        RBucket<String> bucket = redisson.getBucket("hello", fastcode);

        bucket.set("one");

        System.out.println(bucket.get() + "===========");
    }

}
