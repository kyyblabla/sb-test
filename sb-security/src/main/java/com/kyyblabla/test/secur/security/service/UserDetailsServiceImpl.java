package com.kyyblabla.test.secur.security.service;

import com.kyyblabla.test.secur.model.User;
import com.kyyblabla.test.secur.security.bean.SessionUser;
import com.kyyblabla.test.secur.service.UserService;
import com.kyyblabla.test.secur.util.BeanMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by kyy on 2017/7/13.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byUserName = userService.findByUserName(s);
        if (byUserName == null) {
            throw new UsernameNotFoundException(String.format("用户名不存在 '%s'.", s));
        } else {
            SessionUser sessionUser = BeanMapper.map(byUserName, SessionUser.class);
            return sessionUser;
        }
    }
}
