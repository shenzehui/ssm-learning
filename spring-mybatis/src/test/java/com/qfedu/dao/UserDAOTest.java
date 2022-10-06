package com.qfedu.dao;

import com.qfedu.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/30 17:06
 * @PackageName:com.qfedu.dao
 * @ClassName: UserDAOTest
 * @Description: TODO
 * @Version 1.0
 */
public class UserDAOTest {

    @Test
    public void queryUsers() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applictaionContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
//        System.out.println(userDAO);
        List<User> users = userDAO.queryUsers();
        System.out.println(users);
    }

    @Test
    public void insertUser() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applictaionContext.xml");
        UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
        User user = new User(0, "hanmeimei", "11111", "韩梅梅", "default.jpg");
        int i = userDAO.insertUser(user);
        System.out.println(i);
    }
}