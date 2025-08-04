package com.br.viniciuspadovam.planningpoker.websocket.controller;

import java.util.Set;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.br.viniciuspadovam.planningpoker.user.entity.User;
import com.br.viniciuspadovam.planningpoker.user.service.UserService;
import com.br.viniciuspadovam.planningpoker.vote.EstimateFactory;
import com.br.viniciuspadovam.planningpoker.websocket.dto.VoteChatMessage;

import lombok.extern.slf4j.Slf4j;

@Controller
@MessageMapping("/users")
@Slf4j
public class WebSocketController {
	
private final UserService userService;
	
	public WebSocketController(UserService userService) {
		this.userService = userService;
	}
	
	@MessageMapping("/getUsers")
    @SendTo("/topic/allUsers")
    public Set<User> getUser() {
        return this.userService.getAllUsers();
    }
	
	@MessageMapping("/vote")
    @SendTo("/topic/allUsers")
    public Set<User> vote(@Payload VoteChatMessage message) {
		var content = message.content();
		if(!EstimateFactory.isValueValid(message.type(), content.voteValue()))
			throw new IllegalArgumentException("Valor de horas incorreto.");
		
        this.userService.vote(content.userId(), content.voteValue());
        return this.userService.getAllUsers();
    }

}
