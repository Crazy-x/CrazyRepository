package com.example.demo.cache;

import java.util.concurrent.TimeUnit;

public interface Cache<K, V> {

    V get(K key);

    V get(K key, V defaults);

    boolean exist(K key);

    void put(K key, V value);

    void put(K key, V value, long minutes);

    void put(K key, V value, long timeout, TimeUnit unit);

    void remove(K key);

    long size();

    void clear();

}
