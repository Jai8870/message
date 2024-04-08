package com.example.chat.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chatmessage {
	
	
	private String content;
	private String sender;
	private messageType type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	public messageType getType() {
		return type;
	}
	public void setType(messageType type) {
		this.type = type;
	}
}
