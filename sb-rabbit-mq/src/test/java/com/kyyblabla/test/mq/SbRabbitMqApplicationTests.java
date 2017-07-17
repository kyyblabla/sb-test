package com.kyyblabla.test.mq;

import com.kyyblabla.test.mq.Constants;
import com.kyyblabla.test.mq.SbRabbitMqApplication;
import com.kyyblabla.test.mq.reveiver.Receiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbRabbitMqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() throws InterruptedException {
        rabbitTemplate.convertAndSend(Constants.queueName, "Hello from RabbitMQ!");
    }

}
