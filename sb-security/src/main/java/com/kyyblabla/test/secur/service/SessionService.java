package com.kyyblabla.test.secur.service;

import com.kyyblabla.test.secur.model.User;
import com.kyyblabla.test.secur.security.bean.SessionUser;
import com.kyyblabla.test.secur.security.helper.JwtHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by kyy on 2017/7/13.
 */
@Service
public class SessionService  {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;

    public String login(String name, String pass) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(name, pass);
        Authentication authenticate = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        SessionUser sessionUser = (SessionUser) userDetailsService.loadUserByUsername(name);
        String token = jwtHelper.createToken(sessionUser);
        return token;
    }

}
