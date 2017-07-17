package com.kyyblabla.test.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * Created by kyy on 2017/7/14.
 */
@SpringBootApplication
public class SpringWsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringWsApplication.class, args);
    }

}
