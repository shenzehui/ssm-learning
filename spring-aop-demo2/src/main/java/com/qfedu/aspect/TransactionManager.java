package com.qfedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;

/**
 * @Author szh
 * @Date 2022/7/30 15:12
 * @PackageName:com.qfedu.aspect
 * @ClassName: TransactionManager
 * @Description: TODO
 * @Version 1.0
 */
@Component
@Aspect  //声明此类为切面类
public class TransactionManager {

    //切入点方法定义
    @Pointcut("execution(* com.qfedu.dao.*.*(..))")
    public void pc1(){}


    @Before("pc1()")
    public void begin(){
        System.out.println("-------开启事务");
    }

    @After("pc1()")
    public void commit(){
        System.out.println("-------提交事务");
    }

    @Around("pc1()")
    public Object printExecuteTime(ProceedingJoinPoint point) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object proceed = point.proceed(); //执行切入点方法
        long time2 = System.currentTimeMillis();
        System.out.println("方法执行时间:"+ (time2-time1));
        return proceed;
    }
}
