package com.car.util.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 util.
 */
public final class MD5Util {
    private static final Logger LOG = LoggerFactory.getLogger(MD5Util.class);

    private MD5Util() {
    }

    /**
     * 加密，位移3位，即后三位移到前三位.
     *
     * @param inStr input string
     * @return encrypted string
     */
    public static String encryptStr3Move(String inStr) {
        if (inStr == null || "".equals(inStr)) {
            return "";
        }

        for (int i = 0; i < 3; i++) { //SUPPRESS
            inStr = inStr.substring(inStr.length() - 1, inStr.length()) + inStr.substring(0, inStr.length() - 1);
        }

        return encrypt(inStr);
    }

    /**
     * 加密.
     *
     * @param inStr string
     * @return encrypted string
     */
    public static String encrypt(String inStr) {
        MessageDigest md5 = null;
        try {
            if (inStr == null || "".equals(inStr)) {
                return "";
            }

            md5 = MessageDigest.getInstance("MD5");
            char[] charArray = inStr.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }

            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff; //SUPPRESS
                if (val < 16) { //SUPPRESS
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (NoSuchAlgorithmException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("MD5加密失败", e);
        }
    }
}
