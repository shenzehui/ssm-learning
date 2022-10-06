package com.szh.test;

import com.szh.dao.BookDAOImpl;
import com.szh.proxy.CGLibDynamicProxy;

/**
 * @Author szh
 * @Date 2022/7/29 21:36
 * @PackageName:com.szh.test
 * @ClassName: TestCGLibDynamicProxy
 * @Description: TODO
 * @Version 1.0
 */
public class TestCGLibDynamicProxy {

    public static void main(String[] args) {
        //创建被代理对象
        BookDAOImpl bookDAO = new BookDAOImpl();

        //通过cglib动态dialing类创建代理对象
        CGLibDynamicProxy cgLibDynamicProxy = new CGLibDynamicProxy(bookDAO);

        //代理对象实际上是被代理对象子类，因此代理对象可直接强转为被代理类类型
        BookDAOImpl proxy = (BookDAOImpl) cgLibDynamicProxy.getProxy();

        //使用对象调用方法，实际上并没有执行这个方法，而是执行了代理类中的intercept方法，将当前调用的方法以及方法中的参数传递到intercept方法
        proxy.update();
    }
}
