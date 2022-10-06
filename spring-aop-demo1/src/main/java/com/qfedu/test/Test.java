package com.qfedu.test;

import com.qfedu.dao.BookDAOImpl;
import com.qfedu.proxy.MyStaticProxy;

/**
 * @Author szh
 * @Date 2022/7/29 19:58
 * @PackageName:com.qfedu.test
 * @ClassName: Test
 * @Description: TODO
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        //给代理对象
        BookDAOImpl generalDAO = new BookDAOImpl();
        //为被代理对象创建代理对象
        //MyStaticProxy proxy = new MyStaticProxy(generalDAO);
        //proxy.delete();
    }
}
