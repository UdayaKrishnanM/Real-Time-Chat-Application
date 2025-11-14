package com.websocket.chatApplication.controller;

import com.websocket.chatApplication.configuration.RedisConfig;
import com.websocket.chatApplication.dto.ChatMessage;
import com.websocket.chatApplication.publisher.RedisMessagePublisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final RedisMessagePublisher publisher;
    public ChatController(RedisMessagePublisher publisher){
        this.publisher=publisher;
    }

    @MessageMapping("/chat.sendMessage")
    public void send(ChatMessage chatMessage){
        System.out.println("BACKEND RECEIVED: " + chatMessage.getText());
        publisher.publish(RedisConfig.CHAT_TOPIC,chatMessage);
    }
}
