package com.michael.demoproject.demo;

import com.michael.demoproject.entity.User;
import com.michael.demoproject.service.UserService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    public UserService userService;

    @Before
    public  void  TestCaseBefore(){
        System.out.println("案例准备前..");
    }

    @Test
    public void TestCaseDoing() {
        System.out.println("案例测试中...");
        List<User> users=userService.findAll();
    }

    @After
    public void TestCaseAfter(){
        System.out.println("案例完成后...");
    }
}
