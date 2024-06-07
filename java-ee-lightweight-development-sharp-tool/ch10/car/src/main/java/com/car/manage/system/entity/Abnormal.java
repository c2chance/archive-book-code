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
@Table(name = "car_t_sys_abnormal_car")
public class Abnormal extends Auditable {
    @NotEmpty(message = "标题不允许为空", groups = {New.class, Update.class})
    private String license;
    private String description;


    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
