package com.michael.demoproject.dao;

import com.michael.demoproject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CachePut;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> findAll();

    User inserUser(String userName,String note);

    void deleteUser(User user);

    User findUserById(Long id);

    User updateUserById(User user);

}
