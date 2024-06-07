package com.car.util.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * file read util.
 */
public final class FileReadUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileReadUtil.class);

    private FileReadUtil() {
    }

    /**
     * 读取文件.
     *
     * @param filename 文件路径名
     * @param charset  字符集
     * @return content
     */
    public String read(String filename, String charset) {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        String tmpStr = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), charset));

            while ((tmpStr = reader.readLine()) != null) {
                sb.append(tmpStr);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("读取文件失败", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }

        return sb.toString();
    }
}
