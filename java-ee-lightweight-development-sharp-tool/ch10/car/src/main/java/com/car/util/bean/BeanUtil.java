package com.car.util.bean;

import com.car.util.string.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * bean util.
 */
@SuppressWarnings("unchecked")
public final class BeanUtil {
    private static final Logger LOG = LoggerFactory.getLogger(BeanUtil.class);

    private BeanUtil() {
    }

    /**
     * new a object.
     *
     * @param cls      class
     * @param arrayLen array
     * @param <T>      class
     * @return object
     * @throws Exception exception
     */
    public static <T> T newInstance(Class<T> cls, Integer arrayLen) throws Exception {
        if (cls.isArray()) { //Array
            return (T) Array.newInstance(cls.getComponentType(), arrayLen);
        } else if (cls.isAssignableFrom(Map.class)) { //Map,默认子类HashMap
            return (T) HashMap.class.newInstance();
        } else if (cls.isAssignableFrom(Collection.class) || cls.isAssignableFrom(List.class)) { //List,默认子类ArrayList
            return (T) ArrayList.class.newInstance();
        }
        if (cls.isAssignableFrom(Set.class)) { //Set,默认子类HashSet
            return (T) HashSet.class.newInstance();
        } else { //JavaBean,Map子类，Collection子类
            return (T) cls.newInstance();
        }
    }

    /**
     * new a object.
     *
     * @param o          class
     * @param key        key
     * @param value      value
     * @param arrayIndex array index.
     * @param <T>        class
     * @throws Exception exception
     */
    public static <T> void setT(T o, String key, Object value, Integer arrayIndex) throws Exception {
        //实现接口
        List<Class<?>> clsList = new ArrayList<Class<?>>();
        Collections.addAll(clsList, o.getClass().getInterfaces());

        //赋值
        if (o.getClass().isArray()) { //Array
            Array.set(o, arrayIndex, value);
        } else if (clsList.contains(Map.class)) { //Map
            Method put = o.getClass().getDeclaredMethod("put", new Class[]{Object.class, Object.class});
            put.invoke(o, new Object[]{key, value});
        } else if (clsList.contains(Collection.class) || clsList.contains(List.class) || clsList.contains(Set.class)) {
            Method put = o.getClass().getDeclaredMethod("add", new Class[]{Object.class});
            put.invoke(o, new Object[]{value});
        } else { //JavaBean赋值
            Field f = null;

            try {
                f = o.getClass().getDeclaredField(StringUtil.underline2capitalize(key));
            } catch (Exception e) {
                LOG.warn(e.getMessage());
            }

            if (f != null && StringUtils.isNotBlank(value + "")) {
                f.setAccessible(true);
                if (f.getType().isAssignableFrom(String.class)) {
                    value = value != null ? value + "" : null;
                } else if (f.getType().isAssignableFrom(Long.class)) {
                    value = Long.valueOf(value + "");
                } else if (f.getType().isAssignableFrom(Double.class)) {
                    value = Double.valueOf(value + "");
                } else if (f.getType().isAssignableFrom(Integer.class)) {
                    value = Integer.valueOf(value + "");
                } else if (f.getType().isAssignableFrom(Float.class)) {
                    value = Float.valueOf(value + "");
                }
                f.set(o, value);
            }
        }
    }

}
