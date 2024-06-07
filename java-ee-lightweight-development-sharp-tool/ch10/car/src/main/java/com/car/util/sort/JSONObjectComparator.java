package com.car.util.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;

/**
 * JSON对象排序比较.
 */
public class JSONObjectComparator implements Comparator<JSONObject> {
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
     * @param field 待排属性
     * @param asc   是否升序
     */
    public JSONObjectComparator(String field, boolean asc) {
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
    public int compare(JSONObject o1, JSONObject o2) {
        Object v1 = o1.get(this.field);
        Object v2 = o2.get(this.field);
        int result = CompareObject.compare(v1, v2);

        if (!this.asc) {
            result = -result;
        }

        return result;
    }

}
