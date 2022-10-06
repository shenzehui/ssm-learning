package com.szh.utils;

/**
 * @Author szh
 * @Date 2022/7/30 13:45
 * @PackageName:com.szh.utils
 * @ClassName: TxManager
 * @Description: TODO
 * @Version 1.0
 */
public class TxManager {
    public void begin(){
        System.out.println("----------开启事务");
    }

    public void commit(){
        System.out.println("----------提交事务");
    }
}
