package com.kyyblabla.test.secur.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/7/13.
 */
@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {


    @GetMapping("/{id}")
    public String getInfo(@PathVariable("id") int id) {
        return id + "";
    }

}

