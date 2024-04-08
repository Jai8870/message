package com.example.chat.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

@org.springframework.stereotype.Controller
public class Controller {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public Chatmessage sendMessage(
			@Payload Chatmessage chatmessage
			)
	{
		return  chatmessage;
	}
	
	@MessageMapping("/chat.adduser")
	@SendTo("/topic/public")
	public Chatmessage adduser(
			@Payload Chatmessage chatmessage,
			SimpMessageHeaderAccessor headerAccessor
	){
		headerAccessor.getSessionAttributes().put("username", chatmessage.getSender()) ;
		return  chatmessage;
	}
}
