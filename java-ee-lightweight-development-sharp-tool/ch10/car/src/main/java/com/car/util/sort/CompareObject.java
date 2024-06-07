package com.car.util.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 对象比较器.
 */
public final class CompareObject {
    private CompareObject() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(CompareObject.class);

    /**
     * @param v1 the first object to be compared.
     * @param v2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     */
    public static int compare(Object v1, Object v2) {
        int result = 0;

        if (v1 instanceof String) {
            result = v1.toString().compareTo(v2.toString());
        } else if (v1 instanceof Date) {
            long time = ((Date) v1).getTime() - ((Date) v2).getTime();

            if (time > 0) {
                result = 1;
            } else if (time < 0) {
                result = -1;
            } else {
                result = 0;
            }

        } else if (v1 instanceof Integer) {
            result = ((Integer) v1) - ((Integer) v2);
        } else {
            result = v1.toString().compareTo(v2.toString());
            LOG.warn("不可识别的对象类型，转换字符串比较返回   ");
        }
        return result;
    }

}
