package io.ivanclare.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import io.ivanclare.chat.model.Message;
 
@Controller
public class WebSocketController {
 
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public Message sendMessage(@Payload Message chatMessage) {
        return chatMessage;
    }
 
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public Message addUser(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
 
}
