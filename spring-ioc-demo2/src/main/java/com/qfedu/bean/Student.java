package com.qfedu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author szh
 * @Date 2022/7/29 13:01
 * @PackageName:com.qfedu.bean
 * @ClassName: Student
 * @Description: TODO
 * @Version 1.0
 */
@Component("stu")
//@Scope(value = "prototype")  //非单例模式
@Lazy(value = true)  //默认是懒汉模式 false为饿汉模式
public class Student {
    private String stuNum = "10001";
    private String stuName = "szh";
    private String stuGender;
    private int stuAge;
    private Date enterenceTime;

    //@Autowired(required = false) //默认是必须 ，如果没有找到类型匹配的就会抛出异常
    @Resource
    private Clazz clazz;

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                '}';
    }

    @Autowired
    public void setClazz(@Qualifier("c2") Clazz clazz) {
        this.clazz = clazz;
    }

    @PostConstruct
    public void init() {
        System.out.println("init~~~~~~~~~~");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy~~~~~~");
    }
    public Student() {
        System.out.println("创建对象");
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setEnterenceTime(Date enterenceTime) {
        this.enterenceTime = enterenceTime;
    }
}
