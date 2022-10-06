package com.szh.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author szh
 * @Date 2022/7/30 14:44
 * @PackageName:com.szh.utils
 * @ClassName: MyAspect
 * @Description: TODO
 * @Version 1.0
 */
public class MyAspect {
    public void method1(){
        System.out.println("--------method1");
    }
    public void method2(){
        System.out.println("--------method2");
    }
    public void method3(){
        System.out.println("--------method3");
    }
    public void method4(){
        System.out.println("--------method4");
    }

    //环绕通知的切点方法
    //1.必须带有一个参数 ProceedingJoinPoint类型的参数
    //2.必须有Object类型的返回值
    //3.在前后增强的业务逻辑之间执行Object v = point.proceed();
    //4.方法最后返回切入点方法执行的返回值
    public Object method5(ProceedingJoinPoint point) throws Throwable {
        System.out.println("--------method5----before");
        //此句代码的执行，就表示切入点方法的执行
        Object v = point.proceed();
        System.out.println("--------method5----after");
        return v;
    }
}
