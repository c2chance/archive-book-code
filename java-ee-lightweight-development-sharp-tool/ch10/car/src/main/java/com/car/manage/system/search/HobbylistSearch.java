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
 * hobbylist条件分页查询.
 */
public class HobbylistSearch extends AuditableSpecificationSearch {

    private String empname;

    private String carnum;

    @Override
    protected List<Predicate> getPredicates(Root root, CriteriaQuery query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<>();
        Path enable = root.get("enabled");
        Path createdAt = root.get("createdAt");
        Predicate p = builder.equal(enable, true);
        //Predicate p3 =query.orderBy(builder.desc(root.get("createDate")));
        query.orderBy(builder.desc(createdAt));
        list.add(p);
        if (!Strings.isNullOrEmpty(this.empname)) {
            // 进行标题查询
            Path empname = root.get("empname");
            Predicate p1 = builder.like(empname, "%" + this.empname + "%");
            list.add(p1);
        }
        if (!Strings.isNullOrEmpty(this.carnum)) {
            // 进行工号查询
            Path carnum = root.get("carnum");
            Predicate p1 = builder.like(carnum, "%" + this.carnum + "%");
            list.add(p1);
        }
        return list;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }
}
