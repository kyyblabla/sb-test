package com.kyyblabla.test.ws.config;

import com.kyyblabla.test.ws.handler.TextWsMsgHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by kyy on 2017/7/14.
 */
@EnableWebSocket
@Configuration
public class WsConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(textWsMsgHandler(), "/ws");
    }

    @Bean
    public TextWsMsgHandler textWsMsgHandler() {
        return new TextWsMsgHandler();
    }
}
