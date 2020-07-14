package com.michael.demoproject.Topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener extends MessageListenerAdapter {

    Logger logger= LoggerFactory.getLogger(this.getClass());


    @Override
    public void onMessage(Message message, byte[] bytes) {

        StringRedisSerializer stringRedisSerializer= new StringRedisSerializer();
        String body =stringRedisSerializer.deserialize(message.getBody());
//        String body= new String(message.getBody());

        String topic =new String(bytes);

        logger.info("body:"+body+" topic:"+topic);
    }


}
