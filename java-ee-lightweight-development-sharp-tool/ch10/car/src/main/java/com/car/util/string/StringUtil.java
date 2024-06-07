package com.car.util.string;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转换类.
 */
public final class StringUtil {
    private StringUtil() {
    }

    /**
     * 下划线转驼峰.
     *
     * @param input 待转字符串
     * @return 转换完毕字符串
     */
    public static String underline2capitalize(String input) {
        String regex = "(.*?)_(.*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input.toLowerCase());

        while (m.find()) {
            input = m.group(1) + StringUtils.capitalize(m.group(2));
            m = p.matcher(input);
        }

        return input;
    }

    /**
     * 驼峰转下划线.
     *
     * @param input 待转字符串
     * @return 转换完毕字符串
     */
    public static String capitalize2underline(String input) {
        String regex = "(.*?)([A-Z].*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        while (m.find()) {
            input = m.group(1) + "_" + StringUtils.uncapitalize(m.group(2));
            m = p.matcher(input);
        }

        return input;
    }
}
