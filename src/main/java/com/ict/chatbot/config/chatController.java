package com.ict.chatbot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class chatController {
	@Autowired
	private WebSocketConfig wsc;
	
	
	@RequestMapping(value="chat.do",method=RequestMethod.GET)
	public String gochat() {
		return "chatbot";
	}
	@RequestMapping(value="start.do",method=RequestMethod.GET)
	public String gostart() {
		return "start";
	}
	
	
}
