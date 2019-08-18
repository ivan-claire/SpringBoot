package io.ivanclare.chat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import io.ivanclare.chat.model.Message;
	 
@Component
public class WebSocketEventListenr {
	 
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListenr.class);
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
	        logger.info("Received a new web socket connection");
	}
	 
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	   StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
	 
	  String username = (String) headerAccessor.getSessionAttributes().get("username");
	         
	  if(username != null) {
	            logger.info("User Disconnected : " + username);
	 
	            Message message = new Message();
	            message.setType(Message.MessageType.LEAVE);
	            message.setSender(username);
	 
	            messagingTemplate.convertAndSend("/topic/publicChatRoom", message);
	        }
	    }

}
