package com.car.util.string;

/**
 * 中文工具类.
 */
public final class ChineseUtil {
    private ChineseUtil() {
    }

    /**
     * 判断是否是汉字字符.
     *
     * @param c 字符
     * @return 是： 是汉字， 否则为非汉字
     */
    private static boolean isChinese(char c) {
        return Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN;
    }

    /**
     * 判断是否是汉字标点符号.
     *
     * @param c 符号
     * @return 是： 是符号， 否则为非符号
     */
    public static boolean isPunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        // punctuation, spacing, and formatting characters
        return ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                // symbols and punctuation in the unified Chinese, Japanese and Korean script
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                // fullwidth character or a halfwidth character
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                // vertical glyph variants for east Asian compatibility
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                // vertical punctuation for compatibility characters with the Chinese Standard GB 18030
                || ub == Character.UnicodeBlock.VERTICAL_FORMS
                // ascii
                || ub == Character.UnicodeBlock.BASIC_LATIN;
    }

    /**
     * 判断是否是自定义.
     *
     * @param c 符号
     * @return 是： 是自定义， 否则为自定义
     */
    private static Boolean isUserDefined(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.NUMBER_FORMS
                || ub == Character.UnicodeBlock.ENCLOSED_ALPHANUMERICS
                || ub == Character.UnicodeBlock.LETTERLIKE_SYMBOLS
                || c == '\ufeff'
                || c == '\u00a0';
    }

    /**
     * 判断是否是乱码.
     *
     * @param str 字符串
     * @return 是： 含乱码， 否则为非乱码
     */
    public static Boolean isMessy(String str) {
        float chlength = 0;
        float count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isPunctuation(c) || isUserDefined(c)) {
                continue;
            } else {
                if (!isChinese(c)) {
                    count = count + 1;
                }

                chlength++;
            }
        }

        return count / chlength > 0.3; //SUPPRESS
    }

}
