package com.car.util.json;

import com.alibaba.fastjson.JSON;

/**
 * JSON 工具类.
 */
public final class JsonUtil {
    private JsonUtil() {
    }

    /**
     * 反序列化.
     *
     * @param string 待反序列化序列
     * @param clazz  待反序列化类型
     * @param <T>    类型
     * @return 反序列化对象
     */
    public static <T> T fromString(String string, Class<T> clazz) {
        return JSON.parseObject(string, clazz);
    }

    /**
     * 序列化.
     *
     * @param value value
     * @return 序列化字符串
     */
    public static String toString(Object value) {
        return JSON.toJSONString(value);
    }

    /**
     * clone 对象.
     *
     * @param value 待克隆的对象
     * @param <T>   对象类型
     * @return clone后的对象
     */
    public static <T> T clone(T value) {
        return fromString(toString(value), (Class<T>) value.getClass());
    }
}
