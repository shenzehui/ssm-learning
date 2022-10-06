package com.szh.service.impl;

import com.szh.dao.UserDAO;
import com.szh.pojo.User;
import com.szh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/30 20:11
 * @PackageName:com.szh.service.impl
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.SUPPORTS)
    public List<User> listUsers() {
        return userDAO.queryUsers();
    }
}
