package com.michael.demoproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/redis")
public class RedisController {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/zset")
    @ResponseBody
    public String zset() {
        Set<TypedTuple<String>> typedTupleSet = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            double score = i * 0.1;
            TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }

        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        BoundZSetOperations<String, String> zSetOps = stringRedisTemplate.boundZSetOps("zset1");

        zSetOps.add("value10", 0.26);

        Set<String> setRange = zSetOps.range(1, 6);
        logger.info(setRange.toString());
        Set<String> setScore = zSetOps.rangeByScore(0.2, 0.6);
        logger.info(setScore.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return "success";
    }


    @RequestMapping("/send")
    @ResponseBody

    public String send() {

        redisTemplate.convertAndSend("topic","hello world!");

        return "success";
    }

}
