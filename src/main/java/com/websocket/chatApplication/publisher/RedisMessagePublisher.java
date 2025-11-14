package com.websocket.chatApplication.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.websocket.chatApplication.dto.ChatMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisMessagePublisher {
    private final RedisTemplate<String,String> redisTemplate;
    private final ObjectMapper mapper=new ObjectMapper();
    public RedisMessagePublisher(RedisTemplate<String,String> redisTemplate){
        this.redisTemplate=redisTemplate;
    }


    public void publish(String topic, ChatMessage chatMessage){
        try{
            String json=mapper.writeValueAsString(chatMessage);//convert to json
            redisTemplate.convertAndSend(topic,json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
