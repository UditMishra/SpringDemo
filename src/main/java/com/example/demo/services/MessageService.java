package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.beans.Message;
import com.example.demo.dbs.DatabaseManager;

@Service("messageService")
public class MessageService {

	public List<Message> getMessages() {
		return new ArrayList<>(DatabaseManager.getMessageMap().values());
	}

	public Message getMessage(int messageId) {
		return DatabaseManager.getMessageMap().get(messageId);
	}

	public Message createMessage(Message message) {
		message.setId(DatabaseManager.getMessageMap().size() + 1);
		DatabaseManager.getMessageMap().put(message.getId(), message);
		return getMessage(message.getId());
	}

	public Message updateMessage(int messageId, Message message) {
		message.setId(messageId);
		DatabaseManager.getMessageMap().put(message.getId(), message);
		return getMessage(message.getId());
	}

	public void removeMessage(int messageId) {
		DatabaseManager.getMessageMap().remove(messageId);
	}
}
