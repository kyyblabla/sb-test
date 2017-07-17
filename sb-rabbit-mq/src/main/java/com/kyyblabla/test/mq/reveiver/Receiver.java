package com.kyyblabla.test.mq.reveiver;

import com.kyyblabla.test.mq.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kyy on 2017/7/12.
 */
@Component
public class Receiver {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
