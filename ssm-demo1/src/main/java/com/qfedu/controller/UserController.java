package com.qfedu.controller;

import com.qfedu.bean.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/8/2 1:20
 * @PackageName:com.qfedu.controller
 * @ClassName: UserController
 * @Description: TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    @ResponseBody
    public List<User> list(){
        return userService.listUser();
    }
}
