package com.szh.ioc.test;

import com.szh.ioc.bean.Student;
import com.szh.ioc.servlet.TestServlet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author szh
 * @Date 2022/7/29 12:24
 * @PackageName:com.szh.ioc.test
 * @ClassName: Test5
 * @Description: TODO
 * @Version 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        //使用Spring容器创建对象
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestServlet testServlet = (TestServlet) ctx.getBean("testServlet");
        testServlet.doGet();
    }
}
