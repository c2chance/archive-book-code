package com.car.util.poi.read.impl;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * read sheet handler.
 */
public class ReadSheetHandler implements SheetContentsHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ReadSheetHandler.class);

    private int rownum;        //当前行
    private String[] row;    //当前行数据
    private Object entity;    //POJO对象
    private Class<?> clz;    //POJO类型
    private int dataCount;    //输入数据总数，不包括标题

    private String sheetname;
    private String[] fields;
    private ReadSheetHandlerCallback callback;

    /**
     * init.
     *
     * @param clz      class
     * @param fields   fileds
     * @param callback callback
     */
    public ReadSheetHandler(Class<?> clz, String[] fields, ReadSheetHandlerCallback callback) {
        super();
        this.clz = clz;
        this.fields = fields;
        this.callback = callback;
    }

    /**
     * init.
     *
     * @param callback callback.
     */
    public ReadSheetHandler(ReadSheetHandlerCallback callback) {
        super();
        this.callback = callback;
    }

    @Override
    public void startRow(int rownum) {
        if (LOG.isInfoEnabled()) {
            LOG.info("正在读取(" + (sheetname == null ? "" : sheetname) + ")" + (rownum + 1) + "行数据");
        }

        this.rownum = rownum;

        if (fields != null) {
            this.row = new String[this.fields.length];
        }

        try {
            if (clz != null) {
                entity = clz.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void endRow(int rownum) {
        if (rownum > 0) {
            dataCount++;
        }

        try {
            callback.callback(rownum, row, entity);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void cell(String cellReference, String formattedValue, XSSFComment comment) {
        try {
            short col = new CellReference(cellReference).getCol();

            if (row != null && row.length > col) {
                row[col] = formattedValue;
            }

            callback.before(rownum, col, formattedValue);
            if (rownum > 0 && entity != null) {//数据
                Field f = null;
                try {
                    f = entity.getClass().getDeclaredField(fields[col]);
                } catch (NoSuchFieldException | SecurityException e) {
                    LOG.warn(e.getMessage(), e);
                }
                if (f != null) {
                    f.setAccessible(true);
                    Object value = formattedValue;
                    if (f.getType().isAssignableFrom(String.class)) {
                        value = formattedValue;
                    } else if (f.getType().isAssignableFrom(Long.class)) {
                        value = Long.valueOf(value + "");
                    } else if (f.getType().isAssignableFrom(Double.class)) {
                        value = Double.valueOf(value + "");
                    } else if (f.getType().isAssignableFrom(Integer.class)) {
                        value = Integer.valueOf(value + "");
                    } else if (f.getType().isAssignableFrom(Float.class)) {
                        value = Float.valueOf(value + "");
                    }
                    f.set(entity, value);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void headerFooter(String text, boolean isHeader, String tagName) {
    }

    public int getDataCount() {
        return dataCount;
    }

    public String getSheetname() {
        return sheetname;
    }

    public void setSheetname(String sheetname) {
        this.sheetname = sheetname;
    }

	@Override
	public void endRow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cell(String cellReference, String formattedValue) {
		// TODO Auto-generated method stub
		
	}


}
