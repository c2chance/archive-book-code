package com.car.manage.system.service;

import com.car.manage.system.entity.CarBrand;
import com.car.manage.system.search.CarBrandSearch;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 审核通知服务类.
 */
public interface CarBrandService {

    /**
     * 根据noticeManager id查询notice.
     *
     * @param id noticeManager id
     * @return noticeManager
     */
    CarBrand findById(Long id);

    /**
     * 创建noticeManager.
     *
     * @param notice CarBrandManager
     */
    void create(CarBrand notice);

    /**
     * 根据id删除通知.
     *
     * @param id 通知id
     */
    void delete(Long id);

    /**
     * 更新审核拒绝通知.
     *
     * @param notice 拒绝通知
     */
    void update(CarBrand notice);

    /**
     * 查询所有CarBrand.
     *
     * @return List<CarBrand>
     */
    List<CarBrand> findAll();

    /**
     * 查询所有分页CarBrand.
     * @param CarBrandSearch 分页条件
     * @return List Page<CarBrand>
     */
    Page<CarBrand> findAll(CarBrandSearch CarBrandSearch);


    /**
     * 检查id不为指定id的通知是否存在.
     *
     * @param id     指定id
     * @param title 通知
     * @return true 如果存在， 否则false
     */
    Boolean isExist(Long id, String title);
}
