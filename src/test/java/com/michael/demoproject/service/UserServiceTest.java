package com.michael.demoproject.service;

import com.michael.demoproject.entity.User;
import com.michael.demoproject.service.UserService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
}