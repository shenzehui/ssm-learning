package com.szh.proxy;

import com.szh.dao.GeneralDAO;

/**
 * @Author szh
 * @Date 2022/7/29 19:58
 * @PackageName:com.szh.dao
 * @ClassName: MyStaticProxy
 * @Description: 静态代理对象
 * @Version 1.0
 */
public class MyStaticProxy {

    private GeneralDAO generalDAO;

    public MyStaticProxy(GeneralDAO generalDAO) {
        this.generalDAO = generalDAO;
    }

    public void insert() {
        begin();
        generalDAO.insert();
        commit();
    }

    public void delete() {
        begin();
        generalDAO.delete();
        commit();
    }

    public void update() {
        begin();
        generalDAO.update();
        delete();
    }

    long time1;
    long time2;

    public void begin() {
        time1 = System.currentTimeMillis();
        System.out.println("----开启事务");
    }

    public void commit() {
        time2 = System.currentTimeMillis();
        System.out.println("----提交事务");
        System.out.println(generalDAO.getClass() + "执行时间为：" + (time2 - time1));
    }
}
