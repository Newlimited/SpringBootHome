package com.yuhan.first_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.yuhan.first_project.provider.WebSocketProvider;

import lombok.RequiredArgsConstructor;

@EnableWebSocket // 어노테이션 해준다.
@Configuration  // component 명을 configuration 으로 해준다.
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer{// webSocketConfigurer를 상속해준다.

    private final WebSocketProvider webSocketProvider; //Autowired 안쓰고 final 붙이고 Required어노테이션

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
       //webSocketHandler를 만들어 줘야 하는데 .. 없어서 provider에 생성 해준다.
        registry
        .addHandler(webSocketProvider, "/web-socket")
        .setAllowedOrigins("/*"); // 모든 출처에 대해서 받는다.

    } 
}
