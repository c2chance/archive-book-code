package com.car.manage.system.search;

import com.google.common.base.Strings;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 自主移车分页查询.
 */
public class MovingVehicleSearch extends AuditableSpecificationSearch {
    private String license;
    private Long driverId;

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

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        Path enable = root.get("enabled");
        Predicate p = builder.equal(enable, true);
        Path createdAt = root.get("createdAt");
        query.orderBy(builder.desc(createdAt));
        list.add(p);
        list.add(p);
        if (!Strings.isNullOrEmpty(this.license)) {
            // 车牌号查询
            Path license = root.get("license");
            Predicate p1 = builder.like(license, "%" + this.license + "%");
            list.add(p1);
        }
        if (this.getDriverId() != null) {
            Path driverId = root.get("driver").get("id");
            Predicate predicate = builder.equal(driverId, this.driverId);
            list.add(predicate);
        }
        return list;
    }
}
