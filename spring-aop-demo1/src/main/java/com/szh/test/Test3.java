package com.szh.test;

import com.szh.dao.BookDAOImpl;
import com.szh.service.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author szh
 * @Date 2022/7/30 13:42
 * @PackageName:com.szh.test
 * @ClassName: Test3
 * @Description: TODO
 * @Version 1.0
 */
public class Test3 {

    public static void main(String[] args) {
        //通过Spring容器获取BookDAOImpl的对象，并调用方法
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDAOImpl bookDAO = (BookDAOImpl) ctx.getBean("bookDAO");
//        bookDAO.delete();

        //如果要使用Spring aop面向切面编程，调用切入点方法的对象必须通过Spring容器获取
        //如果一个类中的方法被声明为切入点并且织入了切点之后，通过Spring容器获取该类对象，实则获取到的是一个代理对象
        //如果一个类中的方法没有被声明为切入点，通过Spring容器获取的就是这个类真实创建的对象
        //BookServiceImpl bookService = new BookServiceImpl();
        BookServiceImpl bookService = (BookServiceImpl) ctx.getBean("bookServiceImpl");
//        bookService.addBook();

        bookDAO.insert();
    }
}
