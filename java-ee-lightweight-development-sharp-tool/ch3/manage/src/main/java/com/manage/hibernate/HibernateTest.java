package com.manage.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();// 1、读取配置文件
		SessionFactory sf = conf.buildSessionFactory();// 2、创建SessionFactory
		Session session = sf.openSession();// 3、打开Session
		Transaction tx = null;
		try {
			tx = session.beginTransaction();// 4、开始一个事务
			// 5、持久化操作
			User user = new User();
			user.setId("1");
			user.setName("芹泽");
			user.setPwd("520");
			session.save(user);
			tx.commit();// 6、 提交事务
			System.out.println("数据新增成功！");
		} catch (Exception e) {
			if (null != tx) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();// 7、关闭Session
		}
	}
}
