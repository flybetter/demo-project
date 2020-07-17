package com.michael.demoproject.dao;

import com.michael.demoproject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CachePut;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> findAll();

    int inserUser(User user);

    void deleteUser(User user);

    User findUserById(Integer id);

    User updateUserById(User user);

}
