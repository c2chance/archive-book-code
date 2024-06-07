package com.manage.practise;

import java.util.ArrayList;

public class ObjectDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  // 可以用下面两条Java句子解决：
	  System.out.println(Integer.MIN_VALUE);//打印最小整数:2147483647  
	  System.out.println(Integer.MAX_VALUE);//打印最大整数:-2147483648
	  //相应的浮点数：
	  System.out.println(Float.MIN_VALUE);
	  System.out.println(Float.MAX_VALUE);
	  // 双精度：
	  System.out.println(Double.MIN_VALUE);
	  System.out.println(Double.MAX_VALUE);
	  
	  
	  
	  
	   // 双精度：
      System.out.println(Short.MIN_VALUE);
      System.out.println(Short.MAX_VALUE);
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		Object obj1 = new Object();
		obj1 = "张三";
		obj1 = 123;
		
		Object[] obj2  = new Object[2];
		obj2 [0] = new String("张三");
		obj2 [1] = new Integer(123);
		
		
		Object list = new ArrayList();
		Object obj = "张三";
		
		char c1 = 'f';
		System.out.println(c1);

		Character ch1 = 'f';
		System.out.println(ch1);
		
		String str1 = "ab";
		String str2 = "cd";
		String str3 = str1.concat(str2);
		//System.out.println(str3);
		
		String str4 = "a";
		//System.out.println(str1.contains(str4));
		
		
		
		
		byte by1 = 6;
		//System.out.println(by1);
		
		Byte by2 = 8;
		String test = by2.toString();
		//System.out.println(test);
		//System.out.println(test.getClass());
		
		
		
		
		// short类型
		
		short sh = 8;
		System.out.println(sh);
		Short sh2 = 8;
		System.out.println(sh2);


		
		
		// int类型
		
		int int1 = 6;
		Integer int2 = 8;
		int int3 = int2.intValue();
		
/*		System.out.println(int1);
		System.out.println(int2);
		System.out.println(int3);
		System.out.println(int2.MAX_VALUE);
		System.out.println(int2.MIN_VALUE);*/
		
		
		// long类型
		
		long long1 = 6;
		Long long2 = 8L;
		long long3 = long2.SIZE;
		
/*		System.out.println(long1);
		System.out.println(long2);
		System.out.println(long3);
		System.out.println(long2.MAX_VALUE);
		System.out.println(long2.MIN_VALUE);*/

		
		
		
		
		// float类型
		
		float float1 = 6;
		Float float2 = 8F;
		float float3 = float2.SIZE;
		
/*		System.out.println(float1);
		System.out.println(float2);
		System.out.println(float3);
		System.out.println(float2.MAX_VALUE);
		System.out.println(float2.MIN_VALUE);*/
		
		
		
		
		// double类型
		
		double double1 = 6;
		Double double2 = 8D;
		double double3 = double2.SIZE;
		
/*		System.out.println(double1);
		System.out.println(double2);
		System.out.println(double3);
		System.out.println(double2.MAX_VALUE);
		System.out.println(double2.MIN_VALUE);*/
		
		// boolean类型
		
		boolean boolean1 = true;
		Boolean boolean2 = false;
		boolean boolean3 = boolean2.booleanValue();
		
		System.out.println(boolean1);
		System.out.println(boolean2);
		System.out.println(boolean3);
		System.out.println(boolean2.hashCode());
		System.out.println(boolean2.getClass());
		
		
	}

}
