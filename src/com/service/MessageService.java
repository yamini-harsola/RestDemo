package com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.database.DatabaseClass;
import com.exception.DataNotFoundException;
import com.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "John"));
		messages.put(2L, new Message(2, "Hello Jersey", "Anne"));
	}
	
	public List<Message> getAllMessages() {
		ArrayList list = new ArrayList<Message>(messages.values());
		return  list;
	}
	
	public Message getMessage(long id) {
		Message m = messages.get(id);
		return m;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	
	
}
