package com.car.util.poi.write;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * 加row回调.
 */
public interface InsertRowCallback {
    /**
     * 创建行后回调.
     *
     * @param row 加row
     */
    void rowCallback(Row row);

    /**
     * 创建列回调.
     *
     * @param rowNum rowNum
     * @param cell   cell
     * @param value  value
     * @param data   data
     */
    void cellCallback(int rowNum, Cell cell, Object value, Object data);
}
