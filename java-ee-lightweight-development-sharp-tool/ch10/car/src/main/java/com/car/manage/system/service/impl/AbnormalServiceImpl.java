package com.car.manage.system.service.impl;

import com.car.manage.common.constants.Constants;
import com.car.manage.system.dao.AbnormalRepository;
import com.car.manage.system.entity.Abnormal;
import com.car.manage.system.entity.User;
import com.car.manage.system.search.AbnormalSearch;
import com.car.manage.system.service.AbnormalService;
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
public class AbnormalServiceImpl implements AbnormalService {
    @Autowired
    private AbnormalRepository abnormalRepository;

    @Override
    public Abnormal findById(Long id) {
        return abnormalRepository.findByIdAndEnabled(id, Boolean.TRUE);
    }

    @Override
    public void create(Abnormal notice) {
        notice.setCreatedAt(new Date());
        abnormalRepository.save(notice);
    }

    @Override
    public void delete(Long id) {
        Abnormal notice = abnormalRepository.findOne(id);
        notice.setEnabled(Boolean.FALSE);
        abnormalRepository.save(notice);
    }

    @Override
    public void update(Abnormal notice) {
        Abnormal reason = abnormalRepository.findByIdAndEnabled(notice.getId(), Boolean.TRUE);
        notice.setModifiedAt(new Date());

        notice.setCreatedAt(reason.getCreatedAt());
        notice.setCreatedBy(reason.getCreatedBy());

        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER_KEY);
        notice.setModifiedBy(user);
        abnormalRepository.save(notice);
    }

    @Override
    public List<Abnormal> findAll() {
        return abnormalRepository.findByEnabledOrderByCreatedAtDesc(Boolean.TRUE);
    }

    @Override
    public Page<Abnormal> findAll(AbnormalSearch noticeSearch) {
        return abnormalRepository.findAll(noticeSearch.getSpecification(), noticeSearch.getPageInfo());
    }

    @Override
    public Page<Abnormal> findPage(AbnormalSearch noticeSearch) {
        Page<Abnormal> passs = abnormalRepository.findAll(noticeSearch.getSpecification(), noticeSearch.getPageInfo());
        return passs;
    }


    @Override
    public Boolean isExist(Long id, String title) {
        return abnormalRepository.countByReason(id, title) > 0L;
    }
}
