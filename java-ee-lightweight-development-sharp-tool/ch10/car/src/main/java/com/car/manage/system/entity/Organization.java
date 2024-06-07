package com.car.manage.system.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 组织信息.
 */
@Entity
@Table(name = "car_sys_organization")
public class Organization extends Auditable {
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Organization parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
    }
}
