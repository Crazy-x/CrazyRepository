package com.example.demo.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 数据转移器
 *
 * @author alex
 *
 * @param <T>
 *            原始数据类
 */
public interface PropertyTransfer<T> {

    /**
     * 复制数据对象的属性到当前对象
     * 
     * @param data
     *            数据对象
     */
    public default void transfer(T data) {
        try {
            BeanUtils.copyProperties(this, data);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
