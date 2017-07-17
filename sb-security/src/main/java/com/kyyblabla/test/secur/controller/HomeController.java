package com.kyyblabla.test.secur.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/7/13.
 */
@RestController
public class HomeController {

    @GetMapping({"/home"})
    public String home() {
        return "home";
    }

}
