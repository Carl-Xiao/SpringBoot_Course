package com.xiao;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RedisConfigProperties.class)
public class RedisAutoConfigure {
    RedisConfigProperties redisConfigProperties;

    public RedisAutoConfigure(RedisConfigProperties redisConfigProperties) {
        this.redisConfigProperties = redisConfigProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    RedissonClient singleClient() {
        Config config = new Config();
        String redisAddress = redisConfigProperties.getUrl();
        config.useSingleServer()
                .setAddress(redisAddress)
                .setPassword(redisConfigProperties.getPasswprd())
                .setDatabase(Integer.parseInt(redisConfigProperties.getDatabase()))
                .setKeepAlive(true)
                .setPingConnectionInterval(1000);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}
