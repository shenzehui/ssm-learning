package com.qfedu.ioc.test;

import com.qfedu.ioc.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author szh
 * @Date 2022/7/28 20:59
 * @PackageName:com.qfedu.ioc.test
 * @ClassName: Test2
 * @Description: TODO
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        //使用Spring容器创建对象
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //当spring容器进行初始化的时候，就会加载并解析这个配置文件（dom4j jdom）：把配置文件中的内容读取出来，存放到一个Java对象中
        Student stu = (Student) ctx.getBean("stu2");
        System.out.println(stu);
    }
}
