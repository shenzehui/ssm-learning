package com.qfedu.test;

import com.qfedu.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author szh
 * @Date 2022/7/29 13:09
 * @PackageName:com.qfedu.test
 * @ClassName: Test
 * @Description: TODO
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //1.初始化Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = ((Student) ctx.getBean("stu"));
        Student student2 = ((Student) ctx.getBean("stu"));
        System.out.println(student1);
        System.out.println(student2);
    }
}
