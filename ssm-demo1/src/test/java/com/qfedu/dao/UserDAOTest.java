package com.qfedu.dao;

import com.qfedu.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author szh
 * @Date 2022/8/2 1:07
 * @PackageName:com.qfedu.dao
 * @ClassName: UserDAOTest
 * @Description: TODO
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void queryAllUsers() {
        List<User> users = userDAO.queryAllUsers();
        System.out.println(users);
    }
}