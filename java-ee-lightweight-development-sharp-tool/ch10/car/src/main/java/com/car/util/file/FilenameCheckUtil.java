package com.car.util.file;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * file name check.
 */
public final class FilenameCheckUtil {
    private FilenameCheckUtil() {
    }

    /**
     * 过滤文件名乱码，用于保障生成文件成功.
     *
     * @param filename file name
     * @return file name.
     */
    public static String filterMessycode(String filename) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("([^\\\\\\/\\:\\*\\?\"<>| 　])");
        Matcher m = p.matcher(filename);

        while (m.find()) {
            sb.append(m.group(1));
        }

        return sb.toString();
    }
}
