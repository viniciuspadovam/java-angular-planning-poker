package com.br.viniciuspadovam.planningpoker.websocket.listener;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.br.viniciuspadovam.planningpoker.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketEventListener {
	
	private final SimpMessageSendingOperations messagingTemplate;
	private final UserService userService;
	
	public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate, UserService userService) {
		this.messagingTemplate = messagingTemplate;
		this.userService = userService;
	}

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        log.info("Received a new web socket connection");
        
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        
		String username = accessor.getFirstNativeHeader("username");
			
		if(username != null) {
			log.info("User connected: " + username);
			accessor.getSessionAttributes().put("username", username);
			this.userService.add(username);
		}
    }
    
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    	log.info("Desconnecting user");
    	
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        
        if (username != null) {
            log.info("user disconnected: {}", username);
            
            this.userService.remove(username);
            
            this.messagingTemplate.convertAndSend("/topic/allUsers", this.userService.getAllUsernames());
        }
    }

}
