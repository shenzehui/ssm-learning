package com.szh.service;

import com.szh.pojo.User;
import com.szh.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author szh
 * @Date 2022/7/30 20:13
 * @PackageName:com.szh.service
 * @ClassName: UserServiceTest
 * @Description: TODO
 * @Version 1.0
 */
public class UserServiceTest {

    @Test
    public void listUsers() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applictaionContext.xml");
        UserServiceImpl userService = (UserServiceImpl) ctx.getBean("userServiceImpl");
        List<User> users = userService.listUsers();
        System.out.println(users);
    }
}