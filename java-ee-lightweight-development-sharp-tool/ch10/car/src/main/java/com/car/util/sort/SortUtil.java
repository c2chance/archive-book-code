package com.car.util.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序工具类.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public final class SortUtil {
    private SortUtil() {
    }

    /**
     * 排序.
     *
     * @param list        待排序列
     * @param comparators 比较器序列
     * @param <T>         待排类型
     */
    public static <T> void sort(List<T> list, final List<Comparator<T>> comparators) {
        if (comparators.isEmpty()) {
            throw new RuntimeException("comparators is empty.");
        }
        Comparator<T> comparator = (o1, o2) -> {
            for (Comparator c : comparators) {
                if (c.compare(o1, o2) > 0) {
                    return 1;
                } else if (c.compare(o1, o2) < 0) {
                    return -1;
                }
            }
            return 0;
        };

        Collections.sort(list, comparator);
    }
}
