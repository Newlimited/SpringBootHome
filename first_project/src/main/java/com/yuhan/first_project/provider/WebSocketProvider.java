package com.yuhan.first_project.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketProvider extends TextWebSocketHandler {
    // 원래 provider 라기보다 handler 로 이름을 만들어 주는것이 좋다.
    
    // handler는 계속 연결 과 메세지 수송신과 연결해제를 관리한다.

    // 연결
    //TextWebSocketHandler 에서 AbstractWebSocketHandler 까지 더 들어가면 
    //아래 오버라이드 코드들이 있다. 
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

	}
    // 메세지 송수신
    @Override // 해당 오버라이드도 마찬가지 
    
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	}


    // 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}
}
