package com.car.manage.utils;

import java.security.MessageDigest;

/**
 * 验证码生成工具类.
 */
public class CheckSumBuilder {
    private static final int NUM = 4;
    private static final int NUMBER = 0x0f;

    /**
     * 防止子类调用.
     */
    protected CheckSumBuilder() {
        throw new UnsupportedOperationException();
    }

    /**
     * 组合CheckSum.
     *
     * @param appSecret appSecret
     * @param nonce     nonce
     * @param curTime   curTime
     * @return encode
     */
    public static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("SHA", appSecret + nonce + curTime);
    }

    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder sb = new StringBuilder(len * 2);
        for (int i = 0; i < len; i++) {
            sb.append(HEX_DIGITS[(bytes[i] >> NUM) & NUMBER]);
            sb.append(HEX_DIGITS[bytes[i] & NUMBER]);
        }
        return sb.toString();
    }

    private static final char[] HEX_DIGITS =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}; //SUPPRESS

}
