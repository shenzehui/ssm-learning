package com.qfedu.service.impl;

import com.qfedu.bean.User;
import com.qfedu.dao.UserDAO;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/8/2 1:19
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
    public List<User> listUser() {
        return userDAO.queryAllUsers();
    }
}
