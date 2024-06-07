package com.car.util.poi.read.impl;

/**
 * callback.
 */
public interface ReadSheetHandlerCallback {

    /**
     * 为POJO对象字段赋值之前方法.
     *
     * @param rownum row num
     * @param col col
     * @param formattedValue formatted value
     * @throws Exception 可能的异常
     */
    void before(int rownum, short col, String formattedValue) throws Exception;

    /**
     * 读取数据回调方法.
     *
     * @param rownum rownum
     * @param row row
     * @param entity entity
     * @throws Exception 可能的异常
     */
    void callback(int rownum, String[] row, Object entity) throws Exception;
}
