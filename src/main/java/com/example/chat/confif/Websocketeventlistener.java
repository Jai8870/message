package com.example.chat.confif;



import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.chat.chat.Chatmessage;


import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j

public class Websocketeventlistener {
   
	private final SimpMessageSendingOperations messageTemplate = null;

	
	@EventListener
	public void handleWebSocketDisconnectListener(
			SessionDisconnectEvent event
			) {
		StompHeaderAccessor headeraccessor=StompHeaderAccessor.wrap(event.getMessage());
		String username=(String) headeraccessor.getSessionAttributes().get("username");
		if(username!=null) {
			var chatmessage=Chatmessage.builder();
	 
				
					
			messageTemplate.convertAndSend("/topic/public",chatmessage);
		}
	}
	
}
