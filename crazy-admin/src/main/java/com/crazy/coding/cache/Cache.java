package com.crazy.coding.cache;

import java.util.concurrent.TimeUnit;

/**
 * cahce 方法接口
 */
public interface Cache<K, V> {

    /**
     * 按key获取value
     */
    V get(K key);

    /**
     * 按key获取value，结果为null就返回defaultValue
     */
    V get(K key, V defaults);

    /**
     * 按key获取自增长的值
     */
    V getIncrValue(K key);

    /**
     * 判断key缓存是否存在
     */
    boolean exist(K key);

    /**
     * 新增缓存
     */
    void put(K key, V value);

    /**
     * 自增计数器
     */
    void increment(K key, long value);

    /**
     * 新增缓存，设置过期时间，单位为分钟
     */
    void put(K key, V value, long minutes);

    /**
     * 新增缓存，设置过期时间，自定义时间单位
     */
    void put(K key, V value, long timeout, TimeUnit unit);

    /**
     * 移除key缓存
     */
    void remove(K key);

    /**
     * 现存缓存的容量大小
     */
    long size();

    /**
     * 清空所有缓存
     */
    void clear();
}
