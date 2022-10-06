package com.qfedu.service.impl;

import com.qfedu.dao.UserDAO;
import com.qfedu.pojo.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/30 20:11
 * @PackageName:com.qfedu.service.impl
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
