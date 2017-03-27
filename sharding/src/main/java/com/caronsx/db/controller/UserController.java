package com.caronsx.db.controller;

import com.caronsx.db.model.User;
import com.caronsx.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by yaoshuangxi on 27/02/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    @RequestMapping("/add")
    public void add(){
        userService.add();
    }

}
