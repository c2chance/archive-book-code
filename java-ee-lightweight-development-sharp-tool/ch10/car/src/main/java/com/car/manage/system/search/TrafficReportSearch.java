package com.car.manage.system.search;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 外来车辆进出统计查询.
 */
public class TrafficReportSearch extends AuditableSpecificationSearch {
    private String license;
    private String startDate;
    private String endDate;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        /*List<Predicate> list = new ArrayList<>();
        if (!Strings.isNullOrEmpty(this.license)) {
            Path license = root.get("license");
            Predicate p1 = builder.like(license, "%" + this.license + "%");
            list.add(p1);
        }
        return list;*/
        return null;
    }
}
