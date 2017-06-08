package com.cw.chwo.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by handl on 2017/6/7.
 *
 *      艾特EnableCaching：启用注解驱动的缓存
 */
@Configuration
@EnableCaching
public class ServerSpringRedisConfig {

    @Autowired
    private Environment environment;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(environment.getProperty("redis.hostname"));
        redisConnectionFactory.setPort(Integer.valueOf(environment.getProperty("redis.port")));
        redisConnectionFactory.setPoolConfig(jedisPoolConfig);
        redisConnectionFactory.setTimeout(Integer.valueOf(environment.getProperty("redis.timeout")));
        return redisConnectionFactory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.valueOf(environment.getProperty("redis.maxtotal")));
        jedisPoolConfig.setMaxIdle(Integer.valueOf(environment.getProperty("redis.maxidle")));
        jedisPoolConfig.setNumTestsPerEvictionRun(Integer.valueOf(environment.getProperty("redis.numtestsperevictionrun")));
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(Long.valueOf(environment.getProperty("redis.timebetweenevictionrunsmillis")));
        jedisPoolConfig.setMinEvictableIdleTimeMillis(Long.valueOf(environment.getProperty("redis.minevictableidletimemillis")));
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(Long.valueOf(environment.getProperty("redis.softminevictableidletimemillis")));
        jedisPoolConfig.setMaxWaitMillis(Long.valueOf(environment.getProperty("redis.maxwaitmillis")));
        jedisPoolConfig.setTestOnCreate(Boolean.valueOf(environment.getProperty("redis.testoncreate")));
        jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(environment.getProperty("redis.testonborrow")));
        jedisPoolConfig.setTestOnReturn(Boolean.valueOf(environment.getProperty("redis.testonreturn")));
        jedisPoolConfig.setTestWhileIdle(Boolean.valueOf(environment.getProperty("redis.testwhileidle")));
        jedisPoolConfig.setBlockWhenExhausted(Boolean.valueOf(environment.getProperty("redis.blockwhenexhausted")));
        return  jedisPoolConfig;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(new Jackson2JsonRedisSerializer<>(JavaType.class));
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(JavaType.class));
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }

    //创建redisCache管理器
    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

}
