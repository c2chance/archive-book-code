package com.car.manage.system.search;

import com.car.manage.system.entity.User;

import com.google.common.base.Strings;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * user搜索分页查询参数类.
 */
public class UserSearch extends AuditableSpecificationSearch {
    private String username;

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        Path enable = root.get("enabled");
        Predicate p = builder.equal(enable, true);
        Path symbol = root.get("symbol");
        Predicate p1 = builder.equal(symbol, User.symbol.manager);
        Path createdAt = root.get("createdAt");
        query.orderBy(builder.desc(createdAt));
        list.add(p);
        list.add(p1);
        if (!Strings.isNullOrEmpty(this.username)) {
            Path username = root.get("username");
            list.add(builder.like(username, "%" + this.username + "%"));
        }
        return list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
