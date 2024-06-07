package com.car.util.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * 对象排序.
 */
public class ObjectComparator implements Comparator<Object> {
    private Logger log = LoggerFactory.getLogger(ObjectComparator.class);
    /**
     * 字段.
     */
    private String field;
    /**
     * 是否升序.
     */
    private boolean asc;

    /**
     * 初始化.
     *
     * @param field 待排字段
     * @param asc   是否升序
     */
    public ObjectComparator(String field, boolean asc) {
        super();
        this.field = field;
        this.asc = asc;
    }

    /**
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    public int compare(Object o1, Object o2) {
        int result = 0;

        try {
            Field f1 = o1.getClass().getDeclaredField(field);
            Field f2 = o1.getClass().getDeclaredField(field);

            f1.setAccessible(true);
            f2.setAccessible(true);

            Object v1 = f1.get(o1);
            Object v2 = f2.get(o2);

            result = CompareObject.compare(v1, v2);

            if (!this.asc) {
                result = -result;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("ObjectComparator compare Object error", e);
        }

        return result;
    }
}
