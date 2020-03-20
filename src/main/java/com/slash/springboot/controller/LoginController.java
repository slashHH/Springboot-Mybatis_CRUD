package com.slash.springboot.controller;

import com.slash.springboot.entity.Result;
import com.slash.springboot.entity.User;
import com.slash.springboot.service.UserService;
import com.slash.springboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    //登录
    @ResponseBody
    @RequestMapping("/login")
    public Result login(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println("username:" + username + ", password:" + password);
        User user = userService.findByName(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                attributes.getRequest().getSession().setAttribute("user",user);
                return new Result(true,user.getUsername());
            }

        }
        return new Result(false,"登录失败");

    }

    @GetMapping("/login")
    public String login() {
        return "home/login";
    }
}
