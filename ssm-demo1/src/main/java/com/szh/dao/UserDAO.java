package com.szh.dao;

import com.szh.bean.User;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/8/2 1:04
 * @PackageName:com.szh.dao
 * @ClassName: UserDAO
 * @Description: TODO
 * @Version 1.0
 */
public interface UserDAO {

    List<User> queryAllUsers();
}
