package com.qfedu.test;

import com.qfedu.dao.BookDAOImpl;
import com.qfedu.dao.GeneralDAO;
import com.qfedu.proxy.JDKDynamicProxy;

/**
 * @Author szh
 * @Date 2022/7/29 20:29
 * @PackageName:com.qfedu.test
 * @ClassName: TestJDKDynamicProxy
 * @Description: TODO
 * @Version 1.0
 */
public class TestJDKDynamicProxy {

    public static void main(String[] args) {
        //被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();

        //创建动态代理对象，并将被代理对象传递个到代理类中，赋值给obj
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(bookDAO);

        //proxy就是产生的代理对象：产生的代理对象可以强转成被代理对象实现的接口类型
        GeneralDAO proxy = ((GeneralDAO) jdkDynamicProxy.getProxy());

        //使用代理对象调用方法，并不会执行调用的方法，而是进入创建代理对象时指定的InvocationHandler类中的invoke方法
        //调用的方法作为一个Method参数，传递给invoke方法
        proxy.delete();
    }
}
