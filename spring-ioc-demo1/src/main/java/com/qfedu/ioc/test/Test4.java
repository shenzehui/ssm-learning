package com.qfedu.ioc.test;

import com.qfedu.ioc.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author szh
 * @Date 2022/7/28 22:52
 * @PackageName:com.qfedu.ioc.test
 * @ClassName: Test4
 * @Description: TODO
 * @Version 1.0
 */
public class Test4 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = (Book) ctx.getBean("book");
        Book book2 = (Book) ctx.getBean("book");
        System.out.println(book);
        System.out.println(book2);
    }
}
