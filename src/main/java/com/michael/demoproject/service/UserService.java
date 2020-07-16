package com.michael.demoproject.service;

import com.michael.demoproject.entity.User;

import java.util.List;


public interface UserService {
    public List<User> findAll();

    User inserUser(String userName,String note);

    void deleteUser(Long id);

    User updateUserById(Long id,String userName,String note);

    User findByid(Long id);
}
