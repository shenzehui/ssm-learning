package com.szh.dao;

/**
 * @Author szh
 * @Date 2022/7/29 19:56
 * @PackageName:com.szh.dao
 * @ClassName: BookDAOImpl
 * @Description: 被代理对象
 * @Version 1.0
 */
public class BookDAOImpl{

    public int insert(){
        System.out.println("----insert--book");
//        throw new NullPointerException();
        return 1;
    }

    public void delete(){
        System.out.println("----delete--book");
    }

    public void update(){
        System.out.println("----update--book");
    }

}
