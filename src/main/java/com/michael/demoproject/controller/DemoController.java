package com.michael.demoproject.controller;

import com.michael.demoproject.entity.User;
import com.michael.demoproject.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    public UserService userService;


    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @GetMapping("/findAll.do")
    public List<User> demoRequest(){
        List<User> users=userService.findAll();
        return  users;
    }

    @RequestMapping("/redisaction")
    public void redisAction(){
        redisTemplate.opsForValue().set("key1","value");
    }


    @RequestMapping("/redisstringaction")
    public void redisStringAction(){
        stringRedisTemplate.opsForValue().set("key2","value");
    }


    @RequestMapping("/callback")
    public void redisCallBack(){
        redisTemplate.execute((RedisConnection rs) -> {
            rs.set("key3".getBytes(), "value1".getBytes());
            rs.hSet("key3".getBytes(),"hvalue1".getBytes(),"svalue1".getBytes());
            return  null;
        });
    }


}
