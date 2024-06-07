package com.car.manage.system.dao;

import com.car.manage.system.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 通知数据库访问接口.
 */
public interface NoticeManagerRepository extends JpaRepository<Notice, Long>,
        JpaSpecificationExecutor<Notice> {
    /**
     * 查询所有通知.
     *
     * @param enabled enabled
     * @return List<Notice>
     */
    List<Notice> findByEnabledOrderByCreatedAtDesc(Boolean enabled);

    /**
     * 计算id不为指定id的通知的个数.
     *
     * @param id     指定id
     * @param title 通知
     * @return id不为指定id的通知的个数
     */
    @Query("select count(0) from Notice r where r.id <> :id and r.title = :title and r.enabled = true")
    Long countByReason(@Param("id") Long id, @Param("title") String title);

    /**
     * 根据id和删除标识通知.
     *
     * @param id      id
     * @param enabled 删除通知
     * @return 通知
     */
    Notice findByIdAndEnabled(Long id, Boolean enabled);
}
