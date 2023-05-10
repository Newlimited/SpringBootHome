package com.yuhan.first_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket // 어노테이션 해준다.
@Configuration  // component 명을 configuration 으로 해준다.
public class WebSocketConfig implements WebSocketConfigurer{// webSocketConfigurer를 상속해준다.

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
       //webSocketHandler를 만들어 줘야 하는데 .. 없어서 provider에 생성 해준다.
    } 

    
    
}
