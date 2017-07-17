package com.kyyblabla.test.secur.controller;

import com.kyyblabla.test.secur.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/7/13.
 */
@Slf4j
@RequestMapping("/session")
@RestController
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password) {
        String token = sessionService.login(name, password);
        log.info("token for {}:{}", name, token);
        return token;
    }

}
