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
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by handl on 2017/6/7.
 *
 *      艾特EnableCaching：启用注解驱动的缓存
 *
 *      Spring 提供了四个注解来声明缓存规则
            艾特Cacheable： 表明 Spring 在调用方法之前，首先应该在缓存中查找方法的返回值。
                            如果这个值能够找到，就会返回缓存的值。否则的话，
                            这个方法就会被调用，返回值会放到缓存之中
            艾特CachePut：表明 Spring 应该将方法的返回值放到缓存中。在方法的调用前并不会检查缓存，
                            方法始终都会被调用
            艾特CacheEvict： 表明 Spring 应该在缓存中清除一个或多个条目
            艾特Caching： 这是一个分组的注解，能够同时应用多个其他的缓存注解

        填充缓存：
            艾特Cacheable 和 艾特CachePut 注解都可以填充缓存，但是它们的工作方式略有差
                    艾特Cacheable 首先在缓存中查找条目，如果找到了匹配的条目，那么就不会对方法进行调用了。
                        如果没有找到匹配的条目，方法会被调用并且返回值要放到缓存之中。
                    艾特CachePut 并不会在缓存中检查匹配的值，目标方法总是会被调用，并将返回值添加到缓存之中

        艾特Cacheable和艾特CachePut 有一些共有的属性：
            名称         类型       描述
            value       String[] ：要使用的缓存名称
            condition   String   ： SpEL 表达式，如果得到的值是 false 的话，不会将缓存应用到方法调用上
            key         String   ： SpEL 表达式，用来计算自定义的缓存 key
            unless      String   ： SpEL 表达式，如果得到的值是 true 的话，返回值不会放到缓存之中

        将值放到缓存之中：以方法参数作为key来存储(默认)
        自定义缓存 key：通过 SpEL 表达式实现， Spring 提供了多个用来定义缓存规则的 SpEL 扩展
             表达式              描述
             #root.args         传递给缓存方法的参数，形式为数组
             #root.caches       该方法执行时所对应的缓存，形式为数组
             #root.target       目标对象
             #root.targetClass  目标对象的类，是#root.target.class的简写形式
             #root.method       缓存方法
             #root.methodName   缓存方法的名字，是#root.method.name的简写形式
             #result            方法调用的返回值（不能用在@Cacheable注解上）
             #Argument          任意的方法参数名（如#argName）或参数索引（如#a0或#p0）

        条件化缓存：通过 SpEL 表达式实现
        移除缓存条目：艾特CacheEvict
             属性                类型           描述
             value              String []       要使用的缓存名称
             key                String          SpEL 表达式，用来计算自定义的缓存 key
             condition          String          SpEL 表达式，如果得到的值是 false 的话，缓存不会应用到方法调用上
             allEntries         boolean         如果为 true 的话，特定缓存的所有条目都会被移除掉
             beforeInvocation   boolean         如果为 true 的话，在方法调用之前移除条目。如果为false（默认值）的话，在方法成功调用之后再移除条目
 *
 */
@Configuration
@EnableCaching
public class ServerSpringRedisConfig {

    @Autowired
    private Environment environment;

    /**
     * redis连接工厂
     * @param jedisPoolConfig
     * @return
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(environment.getProperty("redis.hostname"));
        redisConnectionFactory.setPort(Integer.valueOf(environment.getProperty("redis.port")));
        redisConnectionFactory.setPoolConfig(jedisPoolConfig);
        redisConnectionFactory.setTimeout(Integer.valueOf(environment.getProperty("redis.timeout")));
        return redisConnectionFactory;
    }

    /**
     * redis连接池配置
     * @return
     */
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

    /**
     * redis模板配置
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(new Jackson2JsonRedisSerializer<>(JavaType.class));
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return redisTemplate;
    }

    /**
     * redis模板配置
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }

    /**
     * 创建redisCache管理器
     * @param redisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

}
