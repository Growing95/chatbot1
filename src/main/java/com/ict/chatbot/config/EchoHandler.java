package com.ict.chatbot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		session.sendMessage(new TextMessage("<strong>환영합니다. 무엇을 도와드릴까요?</strong><br>"
				+ "<strong>예시> 회원가입, 북마크기능 </strong>"));
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession sess: sessionList) {
			sess.sendMessage(new TextMessage(message.getPayload()));
			if (message.getPayload().equals("회원가입")) {
				sess.sendMessage(new TextMessage("<strong>"+"회원가입은 메인페이지의 우측 상단에 로그인|회원가입 의 버튼을 이용하면 됩니다."+"</strong><br><br>"));
			}else if(message.getPayload().equals("북마크기능")){
				sess.sendMessage(new TextMessage("<strong>"+"북마크 기능은 검색된 데이터 중에서 '저장' 버튼을 누르면"+
								"회원님의 MY페이지안에 북마크리스트에 추가되는 기능입니다."+"</strong><br><br>"));
			}
		}
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
	}
}
