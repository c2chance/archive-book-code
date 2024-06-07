package com.car.util.file;

import java.io.File;
import java.util.List;

/**
 * delete file util.
 */
public final class FileDeleteUtil {
    private FileDeleteUtil() {
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件.
     *
     * @param dir dir
     */
    public static void deleteByDir(String dir) {
        File dirFile = new File(dir);
        File[] list = dirFile.listFiles();

        if (list != null && list.length > 0) {
            for (File file : list) {
                if (file.isDirectory()) {
                    deleteByDir(file.getAbsolutePath());
                    file.delete();
                } else if (file.isFile()) {
                    deleteByFilename(file.getAbsolutePath());
                }
            }

            dirFile.delete();
        }
    }

    /**
     * 根据文件名删除.
     *
     * @param filename file name
     */
    public static void deleteByFilename(String filename) {
        new File(filename).delete();
    }

    /**
     * 批量删除.
     *
     * @param filenames name will be delete
     */
    public static void deleteByDir(List<String> filenames) {
        for (String filename : filenames) {
            deleteByFilename(filename);
        }
    }
}
