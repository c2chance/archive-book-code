package com.car.manage.system.service;

import com.car.manage.system.entity.Abnormal;
import com.car.manage.system.search.AbnormalSearch;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 审核通知服务类.
 */
public interface AbnormalService {

    /**
     * 根据noticeManager id查询notice.
     *
     * @param id noticeManager id
     * @return noticeManager
     */
    Abnormal findById(Long id);

    /**
     * 创建noticeManager.
     *
     * @param notice AbnormalManager
     */
    void create(Abnormal notice);

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
    void update(Abnormal notice);

    /**
     * 查询所有Abnormal.
     *
     * @return List<Abnormal>
     */
    List<Abnormal> findAll();

    /**
     * 查询所有分页Abnormal.
     * @param noticeSearch 分页条件
     * @return List Page<Abnormal>
     */
    Page<Abnormal> findAll(AbnormalSearch noticeSearch);


    /**
     * 分页获取全部通行证信息.
     *
     * @param noticeSearch 条件
     * @return List<Pass>
     */
    Page<Abnormal> findPage(AbnormalSearch noticeSearch);


    /**
     * 检查id不为指定id的通知是否存在.
     *
     * @param id     指定id
     * @param title 通知
     * @return true 如果存在， 否则false
     */
    Boolean isExist(Long id, String title);
}
