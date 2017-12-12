package com.crazy.coding.cache;

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
     * <p>
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，
     * 并且只会被服务器调用一次，类似于Servlet的inti()方法。
     * 运行顺序：构造函数之后，Servlet的init()方法之前。
     * </p>
     */
    @PostConstruct
    public void init() {
        String cache = env.getProperty("application.cache", "redis");

        if (cache.equals("redis")) {

            RedisCacheConfig config = new RedisCacheConfig();

            config.setRedisTemplate(redisTemplate);

            provider = config;
        }
    }

    public static Object get(String key) {
        return provider.get(key);
    }

    public static Object get(String key, Object defaults) {
        return provider.get(key, defaults);
    }

    public static Object getIncrValue(String key) {
        return provider.getIncrValue(key);
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
