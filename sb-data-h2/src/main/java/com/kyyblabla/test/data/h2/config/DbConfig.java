package com.kyyblabla.test.data.h2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kyy on 2017/7/17.
 */
@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@MapperScan({"com.kyyblabla.test.data.**.mapper", "com.kyyblabla.test.data.**.dao"})
@ComponentScan({"com.kyyblabla.test.data.h2"})
public class DbConfig {

}
