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
 * notice条件分页查询.
 */
public class AuthorizationSearch extends AuditableSpecificationSearch {

    private String name;

    private String number;

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        Path enable = root.get("enabled");
        Path createdAt = root.get("createdAt");
        Predicate p = builder.equal(enable, true);
        //Predicate p3 =query.orderBy(builder.desc(root.get("createDate")));
        query.orderBy(builder.desc(createdAt));
        list.add(p);
        if (!Strings.isNullOrEmpty(this.name)) {
            // 进行标题查询

            Path name = root.get("license");
            Predicate p1 = builder.like(name, "%" + this.name + "%");
            list.add(p1);
        }
        if (!Strings.isNullOrEmpty(this.number)) {
            // 进行工号查询
            Path number = root.get("number");
            Predicate p1 = builder.like(number, "%" + this.number + "%");
            list.add(p1);
        }
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
