package com.michael.demoproject.service;

import com.michael.demoproject.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserService {
    public List<User> findAll();

    User inserUser(User user);

    void deleteUser(Integer id);

    User updateUserById(Integer id);

    User findByid(Integer id);
}
