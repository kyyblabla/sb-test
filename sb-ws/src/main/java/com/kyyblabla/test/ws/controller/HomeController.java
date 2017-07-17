package com.kyyblabla.test.ws.controller;

import com.kyyblabla.test.ws.bean.MessageBean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kyy on 2017/7/14.
 */
@Controller
public class HomeController {

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public MessageBean greeting(MessageBean message) {
        MessageBean to = new MessageBean();
        to.setFrom("sys");
        to.setContent(message.getFrom() + " greeting to all:" + message.getContent());
        return to;
    }

}
