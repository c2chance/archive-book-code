package com.car.util.number;

import java.math.BigDecimal;

/**
 * 数字工具类.
 */
public final class NumberUtil {
    private NumberUtil() {
    }

    /**
     * 四舍五入，保留2位数.
     *
     * @param obj 数字
     * @return 四舍五入
     */
    public static String round(Object obj) {
        return round(obj, 2);
    }

    /**
     * 四舍五入.
     *
     * @param obj      数字
     * @param newScale 保留位数
     * @return 四舍五入
     */
    public static String round(Object obj, int newScale) {
        if (obj != null && obj.toString().trim().equals("")) {
            return "";
        }

        BigDecimal bd = new BigDecimal(obj + "");
        BigDecimal bds = bd.setScale(newScale, BigDecimal.ROUND_HALF_UP);
        return bds.toPlainString();
    }
}
