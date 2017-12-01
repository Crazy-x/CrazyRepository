package com.example.demo.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class RedisCacheTemplate implements Cache<String, Object> {

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object get(String key) {
        if (isBlank(key)) {
            return null;
        }

        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Object get(String key, Object defaults) {
        Object value = get(key);
        return value == null ? defaults : value;
    }

    @Override
    public boolean exist(String key) {
        if (isBlank(key)) {
            return false;
        }

        return redisTemplate.hasKey(key);
    }

    @Override
    public void put(String key, Object value) {
        if (isBlank(key)) {
            return;
        }

        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void put(String key, Object value, long minutes) {
        if (isBlank(key)) {
            return;
        }

        redisTemplate.opsForValue().set(key, value, minutes, TimeUnit.MINUTES);
    }

    @Override
    public void put(String key, Object value, long timeout, TimeUnit unit) {
        if (isBlank(key)) {
            return;
        }

        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    @Override
    public void remove(String key) {
        if (isBlank(key)) {
            return;
        }

        if (key.contains("*")) {
            Set<String> keys = redisTemplate.keys(key);
            redisTemplate.delete(keys);
        } else {
            redisTemplate.delete(key);
        }
    }

    @Override
    public long size() {
        return redisTemplate.getConnectionFactory().getConnection().dbSize();
    }

    @Override
    public void clear() {
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

}
