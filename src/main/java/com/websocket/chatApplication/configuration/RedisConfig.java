package com.websocket.chatApplication.configuration;

import com.websocket.chatApplication.Subscriber.RedisMessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {
    public static final String CHAT_TOPIC="chat:messages";

    @Bean
    ChannelTopic topic(){
        return new ChannelTopic(CHAT_TOPIC);
    }
    @Bean
    public RedisMessageListenerContainer container(
            RedisConnectionFactory connectionFactory,
            RedisMessageSubscriber subscriber) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(subscriber, topic());
        return container;
    }
}
