package com.car.manage.system.service.impl;

import com.car.manage.common.constants.Constants;
import com.car.manage.system.dao.NoticeManagerRepository;
import com.car.manage.system.entity.Notice;
import com.car.manage.system.entity.User;
import com.car.manage.system.search.NoticeSearch;
import com.car.manage.system.service.NoticeManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 审核通知服务类.
 */
@Service
public class NoticeManagerServiceImpl implements NoticeManagerService {
    @Autowired
    private NoticeManagerRepository noticeManagerRepository;

    @Override
    public Notice findById(Long id) {
        return noticeManagerRepository.findByIdAndEnabled(id, Boolean.TRUE);
    }

    @Override
    public void create(Notice notice) {
        notice.setCreatedAt(new Date());
        noticeManagerRepository.save(notice);
    }

    @Override
    public void delete(Long id) {
        Notice notice = noticeManagerRepository.findOne(id);
        notice.setEnabled(Boolean.FALSE);
        noticeManagerRepository.save(notice);
    }

    @Override
    public void update(Notice notice) {
        Notice reason = noticeManagerRepository.findByIdAndEnabled(notice.getId(), Boolean.TRUE);
        notice.setModifiedAt(new Date());

        notice.setCreatedAt(reason.getCreatedAt());
        notice.setCreatedBy(reason.getCreatedBy());

        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER_KEY);
        notice.setModifiedBy(user);
        noticeManagerRepository.save(notice);
    }

    @Override
    public List<Notice> findAll() {
        return noticeManagerRepository.findByEnabledOrderByCreatedAtDesc(Boolean.TRUE);
    }

    @Override
    public Page<Notice> findAll(NoticeSearch noticeSearch) {
        return noticeManagerRepository.findAll(noticeSearch.getSpecification(), noticeSearch.getPageInfo());
    }

    @Override
    public Boolean isExist(Long id, String title) {
        return noticeManagerRepository.countByReason(id, title) > 0L;
    }
}
