package com.manage.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.wutka.jox.JOXBeanInputStream;
import com.wutka.jox.JOXBeanOutputStream;

public class DomRea {
	/**
	 * 将xml格式的字符串转换为java对象
	 * 
	 * @param xml
	 * @param className
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Object fromXML(String xml, Class className)
			throws UnsupportedEncodingException {
		ByteArrayInputStream xmlData = new ByteArrayInputStream(
				xml.getBytes("utf-8"));
		JOXBeanInputStream joxIn = new JOXBeanInputStream(xmlData);
		try {
			return (Object) joxIn.readObject(className);
		} catch (IOException exc) {
			exc.printStackTrace();
			return null;
		} finally {
			try {
				xmlData.close();
				joxIn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将java转换为xml格式的字符串
	 * 
	 * @param bean
	 * @return
	 */
	public static String toXML(Object bean) {
		ByteArrayOutputStream xmlData = new ByteArrayOutputStream();
		JOXBeanOutputStream joxOut = new JOXBeanOutputStream(xmlData);
		try {

			joxOut.writeObject(beanName(bean), bean);
			return xmlData.toString();
		} catch (IOException exc) {
			exc.printStackTrace();
			return null;
		} finally {
			try {
				xmlData.close();
				joxOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String beanName(Object bean) {
		String fullClassName = bean.getClass().getName();
		String classNameTemp = fullClassName.substring(
				fullClassName.lastIndexOf(".") + 1, fullClassName.length());
		return classNameTemp.substring(0, 1) + classNameTemp.substring(1);
	}

	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(new File("E:\\manage\\practise\\src\\com\\manage\\xml\\student1.xml"));
			String str = document.asXML();
			Student student = (Student) new DomRea()
					.fromXML(str, Student.class);
			System.out.println(student);
			Student stu = new Student();
			stu.setName("qff");
			stu.setSex("女");
			String st = new DomRea().toXML(stu);
			System.out.println(st);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
