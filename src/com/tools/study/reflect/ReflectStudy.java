package com.tools.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 反射的学习
 * @author Administrator
 *
 */
public class ReflectStudy {
	
	public static void main(String[] args)  {
		//1、反射实例化对象
//		try {
//			getInstance();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//2、反射为变量赋值
//		try {
//			getFields();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//3、反射调用方法
		try {
			getMethods();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用反射技术进行实例化
	 * @throws ClassNotFoundException
	 */
	public static void getInstance() throws ClassNotFoundException{
		Class clazz = Class.forName("com.tools.study.reflect.Example_01");
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		for(int i=0;i<declaredConstructors.length;i++){
			
			Constructor constructor = declaredConstructors[i];
			System.out.println("查看是否允许带有可变数量的参数："+constructor.isVarArgs());
			
			System.out.println("该构造方法的入口参数类型依次为：");
			Class[] parameterTypes = constructor.getParameterTypes();
			for(int j=0;j<parameterTypes.length;j++){
				System.out.println(""+parameterTypes[j]);
			}
			
			System.out.println("该构造在方法可能抛出的异常类型为：");
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for(int j=0;j<exceptionTypes.length;j++){
				System.out.println(""+exceptionTypes[j]);
			}
			
			Example_01 example2 = null;
			while(example2 == null){
				try{
					if(i == 0){
						Object[] parameters = new Object[]{new String[]{"100","200","300"}};
 						example2 = (Example_01)constructor.newInstance(parameters);
					}else if(i == 1){
						example2 = (Example_01)constructor.newInstance("7",5);
					}else if (i == 2){
 						example2 = (Example_01)constructor.newInstance();
					}
				}catch(Exception e){
					System.out.println("在创建对象时抛出异常，下面执行setAccessible()方法");
					//e.printStackTrace();
					constructor.setAccessible(true);
				}
			}
			example2.print();
			System.out.println();
		}
	}
	
	/**
	 * 反射修改参数
	 */
	public static void getFields() throws ClassNotFoundException{
		Example_02 example = new Example_02();
		Class clazz = Class.forName("com.tools.study.reflect.Example_02");
		Field[] deciaredFields = clazz.getDeclaredFields();
		for(int i=0;i<deciaredFields.length;i++){
			Field field = deciaredFields[i];
			System.out.println("名称为："+field.getName());
			Class fieldType = field.getType();
			System.out.println("类型为："+fieldType);
			boolean isTurn = true;
			while(isTurn){
				try{
					isTurn = false;
					System.out.println("修改前的值为："+field.get(example));
					if(fieldType.equals(int.class)){
						System.out.println("利用方法setInt()修改成员变量的值");
						field.setInt(example, 168);
					}else if(fieldType.equals(float.class)){
						System.out.println("利用方法setFloat()修改成员变量的值");
						field.setFloat(example, 99.9F);
					}else if(fieldType.equals(boolean.class)){
						System.out.println("利用方法setBoolean()修改成员变量的值");
						field.setBoolean(example, true);
					}else{
						System.out.println("利用方法set修改成员变量的值");
						field.set(example,"吴海波");
					}
					//获取成员变量
					System.out.println("修改后的值为："+field.get(example));
				}catch(Exception e){ 
					System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法！");
					field.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * 反射获取和调用所有方法
	 * @throws ClassNotFoundException 
	 */
	public static void getMethods() throws ClassNotFoundException{
		Example_03 example = new Example_03();
		Class clazz = Class.forName("com.tools.study.reflect.Example_03");
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(int i=0;i<declaredMethods.length;i++){
			Method method = declaredMethods[i];
			System.out.println("名称为："+method.getName());
			
			System.out.println("是否允许带有可变数量的参数："+method.isVarArgs());
			
			System.out.println("入口参数依次是：");
			Class[] parameterTypes = method.getParameterTypes();
			for(int j=0;j<parameterTypes.length;j++){
				System.out.println(""+parameterTypes[j]);
			}
			
			System.out.println("返回值类型是："+method.getReturnType());
			
			System.out.println("可能抛出的异常类型有：");
			Class[] exceptionTypes = method.getExceptionTypes();
			for(int j=0;j<exceptionTypes.length;j++){
				System.out.println(""+exceptionTypes[j]);
			}
			
			boolean isTurn = true;
			while(isTurn){
				try{
					isTurn = false;
					if("staticMethod".equals(method.getName())){
						method.invoke(example);
					}else if("publicMethod".equals(method.getName())){
						System.out.println("返回值为："+method.invoke(example, 168));
						
					}else if("privateMethod".equals(method.getName())){
						Object[] parameters = new Object[]{new String[]{"M","W","Q"}};
						System.out.println("返回值为："+method.invoke(example, parameters));
						
					}else if("protectedMethod".equals(method.getName())){
						System.out.println("返回值为："+method.invoke(example, "7",5));
					}
				}catch(Exception e){
					System.out.println("在执行方法时抛出异常，下面执行setAccessible()方法！");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}
