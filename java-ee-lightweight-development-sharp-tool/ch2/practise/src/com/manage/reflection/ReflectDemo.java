package com.manage.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
	public Object getObject(String name) {
		Object obj = null;
		try {
			Class classType = Class.forName(name);
			obj = classType.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Object copy(Object object) throws Exception {
		// 获得对象的类型
		Class<?> classType = object.getClass();
		System.out.println("class名称:" + classType.getName());

		// 通过默认构造方法创建一个新的对象
		Object objectCopy = classType.getConstructor(new Class[] {})
				.newInstance(new Object[] {});
		Object objectCopyTemp = classType.newInstance();
		// 输出原对象
		System.out.println(object);
		// 输出复制对象
		System.out.println(objectCopy);
		System.out.println(objectCopyTemp);

		// 获得对象的所有属性
		Field fields[] = classType.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();

			// 获得get方法的名称
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			// 获得set方法的名称
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			// 通过名称生成get方法
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			// 通过名称生成set方法
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { field.getType() });

			// 获得原对象的数据
			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + "：" + value);
			// 调用复制对象的set方法赋予原对象的数据
			setMethod.invoke(objectCopy, new Object[] { value });
		}
		return objectCopy;
	}

	public static void main(String[] args) throws Exception {
		Student student = new Student("张三", 20);
		student.setId(new Long(1));

		Student studentCopy = (Student) new ReflectDemo().copy(student);
		System.out.println("复制后的student数据：" + studentCopy.getId() + " "
				+ student.getName() + " " + studentCopy.getAge());

		ReflectDemo demo = new ReflectDemo();
		// 生成新的Student类
		Object obj = demo.getObject("com.manage.reflection.Student");
		System.out.println(obj);
		// 把Object类型转换成Student类型
		Student stu = (Student) obj;
		stu.setName("李四");
		System.out.println("转换后的student数据：" + stu.getName());
	}
}
