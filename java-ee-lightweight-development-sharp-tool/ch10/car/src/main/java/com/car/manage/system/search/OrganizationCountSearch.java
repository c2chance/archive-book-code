package com.car.manage.system.search;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 组织名称查询.
 */
public class OrganizationCountSearch extends AuditableSpecificationSearch {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        Path name = root.get("name");
        List<Predicate> list = new ArrayList<>();
        list.add(builder.equal(name, this.name));
        return list;
    }
}
