package com.car.manage.system.search;

import com.google.common.base.Strings;
import com.car.manage.system.entity.AuditStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 违章查询search.
 */
public class VehicleViolationSearch extends AuditableSpecificationSearch {
    private String license;
    private Long driverId;
    private String status;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        Path enable = root.get("enabled");
        Predicate predicate1 = builder.equal(enable, true);
        Path createdAt = root.get("createdAt");
        query.orderBy(builder.desc(createdAt));
        list.add(predicate1);
        if (!Strings.isNullOrEmpty(this.license)) {
            Path license = root.get("license");
            Predicate predicate = builder.like(license, "%" + this.license + "%");
            list.add(predicate);
        }
        if (this.getDriverId() != null) {
            Path driverId = root.get("driver").get("id");
            Predicate predicate = builder.equal(driverId, this.driverId);
            list.add(predicate);
        }
        if (!Strings.isNullOrEmpty(this.status)) {
            Path auditStatus = root.get("auditStatus");
            Predicate predicate = builder.equal(auditStatus, AuditStatus.valueOf(this.status));
            list.add(predicate);
        }
        return list;
    }
}
