package com.car.manage.system.audit;

import com.car.manage.common.constants.Constants;
import com.car.manage.system.entity.Auditable;
import com.car.manage.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * audit listener.
 */
@Component
public class HibernateAuditListener implements PreInsertEventListener, PreUpdateEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateAuditListener.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        Object obj = event.getEntity();

        if (obj instanceof Auditable) {
            Auditable auditable = (Auditable) obj;
            Date date = new Date();

            auditable.setCreatedAt(date);
            auditable.setModifiedAt(date);
            if (!((Auditable) obj).getEnabled().equals(Boolean.FALSE)) {
                auditable.setEnabled(Boolean.TRUE);
            }

            try {
                //TODO 如果要进行前后端拆分的时候， 这里需要进行调整
                Session session = SecurityUtils.getSubject().getSession();
                User user = (User) session.getAttribute(Constants.SESSION_USER_KEY);
                auditable.setCreatedBy(user);
                auditable.setModifiedBy(user);
            } catch (Exception e) {
                // LOGGER.warn(e.getData(), e);
            }
        }

        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        Object obj = event.getEntity();
        if (obj instanceof Auditable) {
            Auditable auditable = (Auditable) obj;
            Date date = new Date();
            auditable.setModifiedAt(date);

            try {
                //TODO 如果要进行前后端拆分的时候， 这里需要进行调整
                Session session = SecurityUtils.getSubject().getSession();
                User user = (User) session.getAttribute(Constants.SESSION_USER_KEY);
                auditable.setModifiedBy(user);
            } catch (Exception e) {
                //  LOGGER.warn(e.getData(), e);
            }
        }

        return false;
    }

    /**
     * 注册监听器.
     */
    @PostConstruct
    public void registerListeners() {
        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
                EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(this);
        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(this);
    }
}
