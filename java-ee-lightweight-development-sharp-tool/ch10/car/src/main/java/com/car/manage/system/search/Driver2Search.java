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
 * driver条件分页查询.
 */
public class Driver2Search extends AuditableSpecificationSearch {

    private String license;

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        Path enable = root.get("enabled");
        Path createdAt = root.get("createdAt");
        Predicate p = builder.equal(enable, true);
        query.orderBy(builder.desc(createdAt));
        list.add(p);
        Path lic = root.get("license");
        Predicate p0 = builder.isNotNull(lic);
        list.add(p0);
        if (!Strings.isNullOrEmpty(this.license)) {
            Path license = root.get("license");
            Predicate p1 = builder.like(license, "%" + this.license + "%");
            list.add(p1);
        }
        return list;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
