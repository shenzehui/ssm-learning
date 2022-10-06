package com.qfedu.dao;

import com.qfedu.pojo.User;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/30 17:01
 * @PackageName:com.qfedu.dao
 * @ClassName: UserDAO
 * @Description: TODO
 * @Version 1.0
 */
public interface UserDAO {
    List<User> queryUsers();

    int insertUser(User user);
}
