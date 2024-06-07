package com.car.manage.system.search;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 对比分析条件查询.
 */
public class ContrastReportSearch extends AuditableSpecificationSearch {
    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        return null;
    }
}
