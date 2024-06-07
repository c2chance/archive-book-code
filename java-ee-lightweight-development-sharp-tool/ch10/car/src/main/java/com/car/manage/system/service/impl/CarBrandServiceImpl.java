package com.car.manage.system.service.impl;

import com.car.manage.common.constants.Constants;
import com.car.manage.system.dao.CarBrandRepository;
import com.car.manage.system.entity.CarBrand;
import com.car.manage.system.entity.User;
import com.car.manage.system.search.CarBrandSearch;
import com.car.manage.system.service.CarBrandService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

/**
 * 汽车品牌服务类.
 */
@Service
@Transactional
public class CarBrandServiceImpl implements CarBrandService {
    @Autowired
    private CarBrandRepository CarBrandRepository;

    @Override
    public CarBrand findById(Long id) {
        return CarBrandRepository.findByIdAndEnabled(id, Boolean.TRUE);
    }

    @Override
    public void create(CarBrand CarBrand) {
        DateFormat df=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, 6);   // SUPPRESS // 当前业务不清楚，先暂时写6个小时
        CarBrand.setCreatedAt(new Date());
        //CarBrand.setVisitTime(c.getTime());
        CarBrand.setBeginTime("早晨5点");
        CarBrand.setEndTime("晚上22点");
        CarBrandRepository.save(CarBrand);
    }

    @Override
    public void delete(Long id) {
        CarBrand CarBrand = CarBrandRepository.findOne(id);
        CarBrand.setEnabled(Boolean.FALSE);
        CarBrandRepository.delete(CarBrand);
        //CarBrandRepository.save(CarBrand);
    }

    @Override
    public void update(CarBrand CarBrand) {
        CarBrand reason = CarBrandRepository.findByIdAndEnabled(CarBrand.getId(), Boolean.TRUE);
        CarBrand.setModifiedAt(new Date());

        CarBrand.setCreatedAt(reason.getCreatedAt());
        CarBrand.setCreatedBy(reason.getCreatedBy());

        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER_KEY);
        CarBrand.setModifiedBy(user);
        CarBrand.setBeginTime("早晨5点");
        CarBrand.setEndTime("晚上22点");
        CarBrandRepository.save(CarBrand);
    }

    @Override
    public List<CarBrand> findAll() {
        return CarBrandRepository.findByEnabledOrderByCreatedAtDesc(Boolean.TRUE);
    }

    @Override
    public Page<CarBrand> findAll(CarBrandSearch CarBrandSearch) {
        return CarBrandRepository.findAll(CarBrandSearch.getSpecification(),
                CarBrandSearch.getPageInfo());
    }

    @Override
    public Boolean isExist(Long id, String title) {
        return CarBrandRepository.countByReason(id, title) > 0L;
    }
}
