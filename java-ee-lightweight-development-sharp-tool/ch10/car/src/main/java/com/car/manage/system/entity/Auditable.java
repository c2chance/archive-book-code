package com.car.manage.system.entity;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 可以记录 创建、修改者以及时间的类.
 */
@MappedSuperclass
public class Auditable extends IdEntity {
    /**
     * 无参构造方法,默认enabled.
     */
    public Auditable() {
        this.enabled = true;
    }

    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date createdAt;
    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date modifiedAt;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToOne
    @JoinColumn(name = "modified_by")
    private User modifiedBy;
    @ColumnDefault("true")
    private Boolean enabled;

    /**
     * 创建时间.
     *
     * @return 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 最后更新时间.
     *
     * @return 最后更新时间
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    /**
     * 创建人.
     *
     * @return 创建人
     */
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 最后更新人.
     *
     * @return 最后更新人
     */
    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
