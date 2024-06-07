package com.car.manage.system.search;

import com.car.manage.system.entity.Auditable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 所有的audit bean的父搜索类.
 * 这个类里主要是对audit中的enable进行了处理
 *
 * @param <T> auditable bean
 */
public abstract class AuditableSpecificationSearch<T extends Auditable> {
    private int page;
    private int size;

    /**
     * 创建查询表Specification.
     * 所有JPA中的条件查询都应该从这里取Specification
     *
     * @return 查询条件
     */
    public final Specification getSpecification() {
        return createSpecification();
    }

    private Specification createSpecification() {
        return (root, query, cb) -> {
            List<Predicate> list = getPredicates(root, query, cb);

            if (list == null) {
                list = new ArrayList<>();
            }

            Path enabled = root.get("enabled");
            list.add(cb.equal(enabled, Boolean.TRUE));
            return cb.and(list.toArray(new Predicate[0]));
        };
    }

    /**
     * Creates a WHERE clause for a query of the referenced entity in form of a {@link Predicate} for the given
     * {@link Root} and {@link CriteriaQuery}.
     *
     * @param root    root
     * @param query   query
     * @param builder builder
     * @return a {@link Predicate}, may be {@literal null}.
     */
    protected abstract List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder);

    public int getPage() {
        return page;
    }

    /**
     * 返回分页查询参数Pageable.
     *
     * @return Pageable
     */
    public Pageable getPageInfo() {
        return new PageRequest(page, size);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
