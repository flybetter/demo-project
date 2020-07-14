package com.michael.demoproject.config;

import com.michael.demoproject.Topic.RedisMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;

@Configuration
public class RedisConfig {

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisMessageListener redisMessageListener;


    private ThreadPoolTaskScheduler taskScheduler=null;




    @Bean
    public ThreadPoolTaskScheduler initThreadPoolTaskScheduler(){
        if (taskScheduler != null) {
            return  taskScheduler;
        }
        taskScheduler=new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return  taskScheduler;
    }


    @Bean
    public RedisMessageListenerContainer initRedisContainer(){


        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.setTaskExecutor(initThreadPoolTaskScheduler());
        Topic topic=new ChannelTopic("topic");
        container.addMessageListener(redisMessageListener,topic);
        return container;

    }



    @PostConstruct
    public void init(){
        initRedisTemplate();
    }


    public void initRedisTemplate(){
        RedisSerializer redisSerializer=redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
    }


}

