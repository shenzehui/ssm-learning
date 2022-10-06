package com.szh.service.impl;

import com.szh.bean.User;
import com.szh.dao.UserDAO;
import com.szh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/8/2 1:19
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
    public List<User> listUser() {
        return userDAO.queryAllUsers();
    }
}
