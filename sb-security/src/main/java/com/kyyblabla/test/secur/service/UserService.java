package com.kyyblabla.test.secur.service;

import com.kyyblabla.test.secur.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kyy on 2017/7/13.
 */
@Service
public class UserService {


    private static final Map<String, User> users;
    public static final String MANAGER = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";

    private static final BCryptPasswordEncoder encoder;

    static {
        encoder = new BCryptPasswordEncoder();
        users = new HashMap<>();

        User user1 = genUser(1);
        user1.setRoles(Arrays.asList(MANAGER));
        users.put(user1.getName(), user1);

        User user2 = genUser(2);
        user2.setRoles(Arrays.asList(USER));
        users.put(user2.getName(), user2);

        User user3 = genUser(3);
        user3.setRoles(Arrays.asList(USER));
        users.put(user3.getName(), user3);

    }

    public User findByUserName(String userName) {
        return users.get(userName);
    }


    private static User genUser(int id) {
        User user = new User();
        user.setName(id + "");
        user.setId(id);
        user.setPassword(encoder.encode(id + ""));
        return user;
    }


}
