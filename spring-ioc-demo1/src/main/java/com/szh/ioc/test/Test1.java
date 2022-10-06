package com.szh.ioc.test;

import com.szh.ioc.bean.Student;

import java.util.Date;

/**
 * @Author szh
 * @Date 2022/7/28 20:56
 * @PackageName:com.szh.ioc.test
 * @ClassName: Test1
 * @Description: TODO
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        //创建一个学生对象
        Student student = new Student();
        //给学生对象属性赋值
        student.setStuNum("1001");
        student.setStuName("张三");
        student.setStuGender("男");
        student.setStuAge(12);
        student.setEnterenceTime(new Date());

        System.out.println(student);
    }
}
