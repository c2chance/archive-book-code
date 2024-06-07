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
 * 试卷分页查询.
 */
public class PaperSearch extends AuditableSpecificationSearch {
    private String title;
    private String createBy;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        if (!Strings.isNullOrEmpty(this.title)) {
            Path title = root.get("title");
            list.add(builder.like(title, "%" + this.title + "%"));
        }
        if (!Strings.isNullOrEmpty(this.createBy)) {
            Path createBy = root.get("createBy");
            list.add(builder.like(createBy, "%" + this.createBy + "%"));
        }
        return list;
    }
}
