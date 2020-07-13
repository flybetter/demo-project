package com.michael.demoproject.service.impl;

import com.michael.demoproject.dao.UserMapper;
import com.michael.demoproject.entity.User;
import com.michael.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
