package com.tools.test;

import java.lang.reflect.Constructor;

import com.tools.study.reflect.Example_01;

public class Test3 {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.tools.study.reflect.Example_01");
			Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
			System.out.println(declaredConstructors.length);
			for(int i=0;i<declaredConstructors.length;i++){
				
				Constructor constructor = declaredConstructors[i];
				//System.out.println("查看是否允许带有可变数量的参数："+constructor.isVarArgs());
				
				System.out.println("改构造方法的入口参数类型依次为：");
				Class[] parameterTypes = constructor.getParameterTypes();
				for(int j=0;j<parameterTypes.length;j++){
					System.out.println(""+parameterTypes[j]);
				}
			}
			//Example_01 e = (Example_01)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
