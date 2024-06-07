package com.car.manage.common.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FreeMarkerConfig.
 */
@Component
public class FreeMarkerConfig implements InitializingBean {

    @Autowired
    private Configuration configuration;

    /**
     * 启用freeMark的@shiro标签.
     *
     * @throws Exception exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}

