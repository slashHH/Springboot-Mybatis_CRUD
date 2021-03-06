package com.slash.springboot.controller;

import com.slash.springboot.entity.User;
import com.slash.springboot.service.UserService;
import com.slash.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    public List<User> findAll(){
       return userService.findAll();
    }


}
