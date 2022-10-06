package com.szh.dao;

/**
 * @Author szh
 * @Date 2022/7/29 20:03
 * @PackageName:com.szh.dao
 * @ClassName: StudentDAOImpl
 * @Description: 被代理对象
 * @Version 1.0
 */
public class StudentDAOImpl implements GeneralDAO {
    public void insert(){
        System.out.println("----insert--student");
    }

    public void delete(){
        System.out.println("----delete--student");
    }

    public void update(){
        System.out.println("----update--student");
    }
}
