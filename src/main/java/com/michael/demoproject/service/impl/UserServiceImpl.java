package com.michael.demoproject.service.impl;

import com.michael.demoproject.dao.UserMapper;
import com.michael.demoproject.entity.User;
import com.michael.demoproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("UserService")
public class UserServiceImpl implements UserService {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @CachePut(value = "redisCache",key = "'redis_user_'+#user.getId()")
    public User inserUser(User user) {
        int count=userMapper.inserUser(user);
        return user;
    }

    @Override
    @CacheEvict(value = "redisCache",key = "'redis_user_'+#id")
    public void deleteUser(Integer id) {
        User user=userMapper.findUserById(id);

        if (user != null) {
            userMapper.deleteUser(user);
        }

    }

    @Override
    @Cacheable(value = "redisCache",condition = "#result!='null'",key = "'redis_user_'+#user.getId()")
    public User updateUserById(Integer id) {
        User user=userMapper.findUserById(id);

        if(user!=null){
            userMapper.updateUserById(user);
        }

        return  user;
    }

    @Override
    @CachePut(value = "redisCache",key = "'redis_user_'+#user.getId()")
    public User findByid(Integer id) {
        User user=userMapper.findUserById(id);
        return user;
    }

//    @Scheduled(fixedRate = 1000)
//    @Async
//    public void scheduledTest(){
//        logger.info("scheduled task demo!");
//    }
}
