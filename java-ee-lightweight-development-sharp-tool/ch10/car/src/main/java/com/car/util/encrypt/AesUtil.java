package com.car.util.encrypt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Aes加密.
 */
public final class AesUtil {
    private static Logger log = LoggerFactory.getLogger(AesUtil.class);

    private AesUtil() {
    }

    /**
     * 加密.
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return 加密结果
     */
    public static String encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));  //SUPPRESS
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES"); // 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key); // 初始化
            byte[] result = cipher.doFinal(byteContent);
            return parseByte2HexStr(result); // 将二进制转换成16进制
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            throw new RuntimeException("AES加密出错");
        }
    }

    /**
     * 解密.
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return 解密结果
     */
    public static String decrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes())); //SUPPRESS
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES"); // 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key); // 初始化
            byte[] result = cipher.doFinal(parseHexStr2Byte(content)); //将16进制转换为二进制
            return new String(result); //加密
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            throw new RuntimeException("AES解密出错");
        }
    }

    /**
     * 将二进制转换成16进制.
     *
     * @param buf 二进制
     * @return 16进制
     */
    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);  //SUPPRESS

            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    /**
     * 将16进制转换为二进制.
     *
     * @param hexStr 16进制字符串
     * @return 二进制数组
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }

        byte[] result = new byte[hexStr.length() / 2];

        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);  //SUPPRESS
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);  //SUPPRESS
            result[i] = (byte) (high * 16 + low);  //SUPPRESS
        }

        return result;
    }
}
