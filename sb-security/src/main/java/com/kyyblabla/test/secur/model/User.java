package com.kyyblabla.test.secur.model;

import lombok.Data;

import java.util.List;

/**
 * Created by kyy on 2017/7/13.
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
    private List<String> roles;

}
