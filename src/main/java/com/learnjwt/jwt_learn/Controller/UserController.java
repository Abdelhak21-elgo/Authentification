package com.learnjwt.jwt_learn.Controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnjwt.jwt_learn.Entity.User;
import com.learnjwt.jwt_learn.Service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @PostConstruct
    public void initRolesAndUsers(){
        userservice.initRoleandUser();
    }

    @PostMapping({"/regestNewUser"})
    public User regestNewUser(@RequestBody User user){
        return userservice.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only for Admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "This URL is only for User";
    }
}
