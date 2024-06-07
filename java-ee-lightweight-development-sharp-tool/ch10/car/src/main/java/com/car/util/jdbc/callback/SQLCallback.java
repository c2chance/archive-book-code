package com.car.util.jdbc.callback;

import java.util.List;

/**
 * 用于查询本地数据库时回调.
 *
 * @param <T> class
 */
public interface SQLCallback<T> {

    /**
     * 查询SQL列字段.
     *
     * @param fields fields
     */
    void setFields(String[] fields);

    /**
     * 10000条为一批次返回数据.
     *
     * @param list 数据集合
     * @throws Exception exception
     */
    void run(List<T> list) throws Exception;

}
