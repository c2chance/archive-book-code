package com.car.manage.system.entity;

import com.car.manage.common.constants.New;
import com.car.manage.common.constants.Update;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 外来车辆信息.
 */
@Entity
@Table(name = "car_brand")
public class CarBrand extends Auditable {
    @NotEmpty(message = "标题不允许为空", groups = {New.class, Update.class})
    private String carsBrand;
    private String description;
    private String name;
    private String phone;
    private String friend;
    private String dept;
    private String interest;
    private String beginTime;
    private String endTime;
    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date leaveTime;

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }




    public String getCarsBrand() {
        return carsBrand;
    }

    public void setCarsBrand(String carsBrand) {
        this.carsBrand = carsBrand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
