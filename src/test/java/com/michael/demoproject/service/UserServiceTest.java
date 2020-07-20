package com.michael.demoproject.service;

import com.michael.demoproject.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest  {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public UserService userService;

    @Before
    public void setUp() throws Exception {
//        logger.info("setUp");
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        logger.info("tearDown");
        System.out.println("tearDown");
    }

    @Test
    public void findAll() {
        List <User> users=userService.findAll();
        logger.info(users.toString());

    }


    @Test
    public void inserUser() {

        User user=new User();
        user.setUserName("yyf");
        user.setNote("rich");
        user=userService.inserUser(user);
        logger.info(user.toString());
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(2);
    }

    @Test
    public void updateUserById() {
        User user=userService.updateUserById(2);
        logger.info(user.toString());
    }

    @Test
    public void findByid() {
        User user=userService.findByid(2);
        logger.info(user.toString());
    }
}