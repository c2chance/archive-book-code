package com.car.manage.system.entity;

/**
 * 审核状态.
 */
public enum AuditStatus {
    /**
     * 审核状态--未审核.
     */
    NEW("待审核"),
    /**
     * 审核状态--通过.
     */
    PASS("通过"),
    /**
     * 审核状态--未通过.
     */
    FAIL("不通过");

    /**
     * 构造.
     *
     * @param name name
     */
    AuditStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
