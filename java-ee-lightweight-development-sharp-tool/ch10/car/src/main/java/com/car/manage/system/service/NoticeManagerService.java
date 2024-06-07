package com.car.manage.system.service;

import com.car.manage.system.entity.Notice;
import com.car.manage.system.search.NoticeSearch;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 审核通知服务类.
 */
public interface NoticeManagerService {

    /**
     * 根据noticeManager id查询notice.
     *
     * @param id noticeManager id
     * @return noticeManager
     */
    Notice findById(Long id);

    /**
     * 创建noticeManager.
     *
     * @param notice NoticeManager
     */
    void create(Notice notice);

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
    void update(Notice notice);

    /**
     * 查询所有Notice.
     *
     * @return List<Notice>
     */
    List<Notice> findAll();

    /**
     * 查询所有分页Notice.
     * @param noticeSearch 分页条件
     * @return List Page<Notice>
     */
    Page<Notice> findAll(NoticeSearch noticeSearch);


    /**
     * 检查id不为指定id的通知是否存在.
     *
     * @param id     指定id
     * @param title 通知
     * @return true 如果存在， 否则false
     */
    Boolean isExist(Long id, String title);
}
