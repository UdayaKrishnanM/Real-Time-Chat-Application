package com.websocket.chatApplication.Subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.chatApplication.dto.ChatMessage;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageSubscriber implements MessageListener {
    private final SimpMessagingTemplate template;
    private final ObjectMapper mapper=new ObjectMapper();

    public RedisMessageSubscriber(SimpMessagingTemplate template){
        this.template=template;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try{
            String json=new String(message.getBody());
            ChatMessage chatMessage=mapper.readValue(json,ChatMessage.class);
            template.convertAndSend("/topic/public",chatMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
