package com.car.manage.view;

/**
 * 响应消息.
 *
 * @param <T> 消息内容
 */
public class Message<T extends Object> {
    private Boolean success;
    private Object data;

    /**
     * 响应消息.
     *
     * @param success 是否成功
     * @param data    返回数据
     */
    public Message(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    /**
     * init.
     *
     * @param success 是否成功
     */
    public Message(Boolean success) {
        this.success = success;
    }

    /**
     * init.
     */
    public Message() {
        this.success = Boolean.TRUE;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
