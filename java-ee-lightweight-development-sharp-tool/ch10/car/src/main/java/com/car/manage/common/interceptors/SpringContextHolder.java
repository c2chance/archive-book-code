package com.car.manage.common.interceptors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * spring context holder.
 */
@Component
public class SpringContextHolder implements ApplicationListener<ContextRefreshedEvent> {
    private static ApplicationContext applicationContext;

    /**
     * 获取bean.
     *
     * @param clazz bean class
     * @return bean
     */
    public static Object getBean(Class clazz) {
        return applicationContext.getBean(clazz);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        applicationContext = contextRefreshedEvent.getApplicationContext();
    }
}
