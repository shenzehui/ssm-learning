package com.qfedu.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author szh
 * @Date 2022/7/29 21:30
 * @PackageName:com.qfedu.dao
 * @ClassName: CGLibDynamicProxy
 * @Description: TODO
 * @Version 1.0
 */

/**
 * CGlib动态代理
 * 1.添加cglib依赖
 * 2.创建一个类，实现MethodInterceptor接口，同时实现接口中的intercept方法
 * 3.在类中定义一个Object类的变量，并提供这个变量的有参构造器，用于传递被代理对象
 * 3.定义getProxy方法创建并返回代理对象（代理对象是通过创建被代理类的子类来创建的）
 */
public class CGLibDynamicProxy implements MethodInterceptor {

    private Object object;

    public CGLibDynamicProxy(Object object) {
        this.object = object;
    }

    //产生代理对象
    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        //设置被代理对象的父类
        enhancer.setSuperclass(object.getClass());
        //设置回调，用于intercept的执行
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }

    @Override  //这里相当于JDK中的invoke方法  objects是方法执行的参数
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        begin();
        Object returnValue = method.invoke(object,objects);  //通过反射调用被代理类方法
        commit();
        return returnValue;
    }

    public void begin(){
        System.out.println("---------开启事务");
    }

    public void commit(){
        System.out.println("---------提交事务");
    }
}
