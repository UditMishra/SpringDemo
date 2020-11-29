package com.example.demo.controllers.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.beans.Message;
import com.example.demo.services.MessageService;

@RestController
public class MessageRestController {

	@Autowired
	private MessageService messageService;

	@GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Message> getMessages() {
		return messageService.getMessages();
	}

	@GetMapping(path = "/messages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message getMessage(@PathVariable("id") int id) {
		return messageService.getMessage(id);
	}

	
	@PostMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> createMessage(@RequestBody Message message) {
		Message newMessage = messageService.createMessage(message);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newMessage.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/messages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
		return messageService.updateMessage(id, message);
	}

	@DeleteMapping(path = "/messages/{id}")
	public void removeMessage(@PathVariable("id") int id) {
		messageService.removeMessage(id);
	}

}
