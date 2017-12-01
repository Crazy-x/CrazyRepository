package com.example.demo.cache;

import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {

    @Resource
    private Environment env;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static Cache<String, Object> provider;

    /**
     * 初始化缓存提供者
     */
    @PostConstruct
    public void init() {
        String cache = env.getProperty("application.cache", "redis");

        if (cache.equals("redis")) {
            RedisCacheTemplate redisCacheTemplate = new RedisCacheTemplate();
            redisCacheTemplate.setRedisTemplate(redisTemplate);
            provider = redisCacheTemplate;
        }
    }

    public static Object get(String key) {
        return provider.get(key);
    }

    public static Object get(String key, Object defaults) {
        return provider.get(key, defaults);
    }

    public static boolean exist(String key) {
        return provider.exist(key);
    }

    public static void put(String key, Object value) {
        provider.put(key, value);
    }

    public static void put(String key, Object value, long minutes) {
        provider.put(key, value, minutes);
    }

    public static void put(String key, Object value, long timeout, TimeUnit unit) {
        provider.put(key, value, timeout, unit);
    }

    public static void remove(String key) {
        provider.remove(key);
    }

    public static long size() {
        return provider.size();
    }

    public static void clear() {
        provider.clear();
    }

}
