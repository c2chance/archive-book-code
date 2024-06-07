package com.car.util.number;

import java.text.NumberFormat;

/**
 * 百分比.
 */
public final class ProgressUtil {
    private ProgressUtil() {
    }

    /**
     * 百分比，保留2位数.
     *
     * @param cur    当前数
     * @param counts 总数
     * @return 百分比，保留2位数.
     */
    public static String progress(double cur, double counts) {
        return progress(cur, counts, 2);
    }

    /**
     * 百分比，保留2位数.
     *
     * @param cur      当前数
     * @param counts   总数
     * @param newValue new value
     * @return 百分比，保留2位数.
     */
    public static String progress(double cur, double counts, int newValue) {
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(newValue);
        return nf.format(cur / counts);
    }
}
