package com.szh.dao;

import com.szh.pojo.User;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/27 13:48
 * @PackageName:com.szh.dao
 * @ClassName: UserDao
 * @Description: TODO
 * @Version 1.0
 */
public interface UserDao {

    int insertUser(User user);

    //根据用户名查询用户信息
    User queryUser(String username);
}
