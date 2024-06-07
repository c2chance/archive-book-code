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
 * role搜索分页查询参数类.
 */
public class RoleSearch extends AuditableSpecificationSearch {
    private String searchKey;

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();

        if (!Strings.isNullOrEmpty(this.searchKey)) {
            Path roleName = root.get("roleName");
            list.add(builder.like(roleName, "%" + this.searchKey + "%"));
        }
        return list;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
