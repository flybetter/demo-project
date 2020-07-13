package com.michael.demoproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

@Configuration
public class RedisConfig {

    @Autowired
    public RedisTemplate redisTemplate=null;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }


    public void initRedisTemplate(){
        RedisSerializer redisSerializer=redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
    }
}
