package com.car.manage.system.entity;

import com.car.manage.common.constants.New;
import com.car.manage.common.constants.Update;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 通知信息.
 */
@Entity
@Table(name = "car_notice_manager")
public class Notice extends Auditable {
    @NotEmpty(message = "标题不允许为空", groups = {New.class, Update.class})
    private String title;
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
