package com.car.manage.system.dao;

import com.car.manage.system.entity.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 通知数据库访问接口.
 */
public interface CarBrandRepository extends JpaRepository<CarBrand, Long>,
        JpaSpecificationExecutor<CarBrand> {
    /**
     * 查询所有通知.
     *
     * @param enabled enabled
     * @return List<CarBrand>
     */
    List<CarBrand> findByEnabledOrderByCreatedAtDesc(Boolean enabled);

    /**
     * 计算id不为指定id的通知的个数.
     *
     * @param id     指定id
     * @param license 通知
     * @return id不为指定id的通知的个数
     */
    @Query("select count(0) from CarBrand r where r.id <> :id and r.carsBrand = :carsBrand and r.enabled = true")
    Long countByReason(@Param("id") Long id, @Param("carsBrand") String carsBrand);


    /**
     *
     * @return List
     */
    @Query("SELECT p FROM CarBrand p WHERE DATE(p.createdAt) <> DATE(p.leaveTime)")
    List<CarBrand> findByEnabledOrderByCreatedAtDesc();

    /**
     * 根据id和删除标识通知.
     *
     * @param id      id
     * @param enabled 删除通知
     * @return 通知
     */
    CarBrand findByIdAndEnabled(Long id, Boolean enabled);
}
