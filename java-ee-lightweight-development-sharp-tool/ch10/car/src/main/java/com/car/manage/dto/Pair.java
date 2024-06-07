package com.car.manage.dto;

import java.io.Serializable;

/**
 * 键值对.
 */
public class Pair implements Serializable {
    /**
     * 初始化.
     */
    public Pair() {
    }

    /**
     * 初始化.
     *
     * @param key   键
     * @param value 值
     */
    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    private Object key;
    private Object value;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
