package com.kyyblabla.test.data.h2.controller;

import com.kyyblabla.test.data.h2.model.User;
import com.kyyblabla.test.data.h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/7/17.
 */
@RestController
public class HelloController {


    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") long id) {
        return userService.getById(id);
    }


}
