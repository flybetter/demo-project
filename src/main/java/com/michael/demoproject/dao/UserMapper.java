package com.michael.demoproject.dao;

import com.michael.demoproject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CachePut;

import java.util.List;
@Mapper
public interface UserMapper {
    @CachePut
    List<User> findAll();
}
