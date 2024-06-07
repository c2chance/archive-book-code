package com.car.util.date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 时间操作工具.
 */
public final class DateUtil {
    private DateUtil() {
    }

    /**
     * 将yyyy-MM-dd HH:mm:dd字符串转换为日期类型.
     *
     * @param dateStr yyyy-MM-dd HH:mm:dd字符串
     * @return 日期
     * @throws ParseException 可能的异常
     */
    public static Date parseDatetime(String dateStr) throws ParseException {
        return DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将yyyyMMdd字符串转换为日期类型.
     *
     * @param dateStr yyyyMMdd字符串
     * @return 日期
     * @throws ParseException 可能的异常
     */
    public static Date parseYyyyMMdd(String dateStr) throws ParseException {
        return DateUtils.parseDate(dateStr, "yyyyMMdd");
    }

    /**
     * 将日期类型转换为 yyyyMMdd字符串.
     *
     * @param date 日期
     * @return 时间字符串
     */
    public static String formatYyyyMMdd(Date date) {
        if (date == null) {
            return "";
        }

        return DateFormatUtils.format(date, "yyyyMMdd");
    }

    /**
     * 将日期类型转换为yyyy-MM-dd HH:mm:ss字符串.
     *
     * @param date 日期
     * @return 时间字符串
     */
    public static String formatDatetime(Date date) {
        if (date == null) {
            return "";
        }

        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }
}
