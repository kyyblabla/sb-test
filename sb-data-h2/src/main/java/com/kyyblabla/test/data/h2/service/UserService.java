package com.kyyblabla.test.data.h2.service;

import com.kyyblabla.test.data.h2.mapper.UserMapper;
import com.kyyblabla.test.data.h2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kyy on 2017/7/17.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getById(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

}
