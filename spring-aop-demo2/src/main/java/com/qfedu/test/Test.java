package com.qfedu.test;

import com.qfedu.dao.UserDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author szh
 * @Date 2022/7/30 15:10
 * @PackageName:com.qfedu.test
 * @ClassName: Test
 * @Description: TODO
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml ");
        UserDAOImpl userDAOImpl = (UserDAOImpl) ctx.getBean("userDAOImpl");
        userDAOImpl.insert();
    }
}
