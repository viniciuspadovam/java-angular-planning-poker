package com.br.viniciuspadovam.planningpoker.websocket.controller;

import java.util.Set;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.br.viniciuspadovam.planningpoker.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WebSocketController {
	
private final UserService userService;
	
	public WebSocketController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@MessageMapping("/getUsers")
    @SendTo("/topic/allUsers")
    public Set<String> getUser() {
        return this.userService.getAllUsernames();
    }

}
