package com.car.manage.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密解密.
 */
public class CryptographyUtil {

    /**
     * 防止子类调用.
     */
    protected CryptographyUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * enbase64.
     *
     * @param str str
     * @return String
     */
    public static String encBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }

    /**
     * debase64.
     *
     * @param str str
     * @return String
     */
    public static String decBase64(String str) {
        return Base64.decodeToString(str);
    }

    /**
     * md5.
     *
     * @param str  str
     * @param salt salt
     * @return String
     */
    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }
}
