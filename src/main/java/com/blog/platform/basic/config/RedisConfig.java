package com.blog.platform.basic.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis 配置类
 *
 * @author: rookie
 * @date: 2020-10-10
 */
@Configuration
public class RedisConfig {

    /**
     * 序列化中文乱码
     *
     * @param connectionFactory 连接工厂
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        // String 的 key 和 hash 的 key 都采用 String 的序列化方式
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        // value 采用 fastjson 的序列化方式
        RedisSerializer<Object> jsonString = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setValueSerializer(jsonString);
        redisTemplate.setHashValueSerializer(jsonString);
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
