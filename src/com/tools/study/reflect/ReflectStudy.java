package com.tools.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * �����ѧϰ
 * @author Administrator
 *
 */
public class ReflectStudy {
	
	public static void main(String[] args)  {
		//1������ʵ��������
//		try {
//			getInstance();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//2������Ϊ������ֵ
//		try {
//			getFields();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//3��������÷���
		try {
			getMethods();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ�÷��似������ʵ����
	 * @throws ClassNotFoundException
	 */
	public static void getInstance() throws ClassNotFoundException{
		Class clazz = Class.forName("com.tools.study.reflect.Example_01");
		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
		for(int i=0;i<declaredConstructors.length;i++){
			
			Constructor constructor = declaredConstructors[i];
			System.out.println("�鿴�Ƿ�������пɱ������Ĳ�����"+constructor.isVarArgs());
			
			System.out.println("�ù��췽������ڲ�����������Ϊ��");
			Class[] parameterTypes = constructor.getParameterTypes();
			for(int j=0;j<parameterTypes.length;j++){
				System.out.println(""+parameterTypes[j]);
			}
			
			System.out.println("�ù����ڷ��������׳����쳣����Ϊ��");
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
					System.out.println("�ڴ�������ʱ�׳��쳣������ִ��setAccessible()����");
					//e.printStackTrace();
					constructor.setAccessible(true);
				}
			}
			example2.print();
			System.out.println();
		}
	}
	
	/**
	 * �����޸Ĳ���
	 */
	public static void getFields() throws ClassNotFoundException{
		Example_02 example = new Example_02();
		Class clazz = Class.forName("com.tools.study.reflect.Example_02");
		Field[] deciaredFields = clazz.getDeclaredFields();
		for(int i=0;i<deciaredFields.length;i++){
			Field field = deciaredFields[i];
			System.out.println("����Ϊ��"+field.getName());
			Class fieldType = field.getType();
			System.out.println("����Ϊ��"+fieldType);
			boolean isTurn = true;
			while(isTurn){
				try{
					isTurn = false;
					System.out.println("�޸�ǰ��ֵΪ��"+field.get(example));
					if(fieldType.equals(int.class)){
						System.out.println("���÷���setInt()�޸ĳ�Ա������ֵ");
						field.setInt(example, 168);
					}else if(fieldType.equals(float.class)){
						System.out.println("���÷���setFloat()�޸ĳ�Ա������ֵ");
						field.setFloat(example, 99.9F);
					}else if(fieldType.equals(boolean.class)){
						System.out.println("���÷���setBoolean()�޸ĳ�Ա������ֵ");
						field.setBoolean(example, true);
					}else{
						System.out.println("���÷���set�޸ĳ�Ա������ֵ");
						field.set(example,"�⺣��");
					}
					//��ȡ��Ա����
					System.out.println("�޸ĺ��ֵΪ��"+field.get(example));
				}catch(Exception e){ 
					System.out.println("�����ó�Ա����ֵʱ�׳��쳣������ִ��setAccessible()������");
					field.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * �����ȡ�͵������з���
	 * @throws ClassNotFoundException 
	 */
	public static void getMethods() throws ClassNotFoundException{
		Example_03 example = new Example_03();
		Class clazz = Class.forName("com.tools.study.reflect.Example_03");
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for(int i=0;i<declaredMethods.length;i++){
			Method method = declaredMethods[i];
			System.out.println("����Ϊ��"+method.getName());
			
			System.out.println("�Ƿ�������пɱ������Ĳ�����"+method.isVarArgs());
			
			System.out.println("��ڲ��������ǣ�");
			Class[] parameterTypes = method.getParameterTypes();
			for(int j=0;j<parameterTypes.length;j++){
				System.out.println(""+parameterTypes[j]);
			}
			
			System.out.println("����ֵ�����ǣ�"+method.getReturnType());
			
			System.out.println("�����׳����쳣�����У�");
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
						System.out.println("����ֵΪ��"+method.invoke(example, 168));
						
					}else if("privateMethod".equals(method.getName())){
						Object[] parameters = new Object[]{new String[]{"M","W","Q"}};
						System.out.println("����ֵΪ��"+method.invoke(example, parameters));
						
					}else if("protectedMethod".equals(method.getName())){
						System.out.println("����ֵΪ��"+method.invoke(example, "7",5));
					}
				}catch(Exception e){
					System.out.println("��ִ�з���ʱ�׳��쳣������ִ��setAccessible()������");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
	}
}
