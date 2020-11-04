package com.tools.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class ToolsBeanUtils {
	public static void main(String[] args) {
		//对象复制
//		PersonDAO personDao = new PersonDAO();
//		personDao.setAge(15);
//		personDao.setName("吴海波");
//		
//		try {
//			PersonDAO person2 =  (PersonDAO)BeanUtils.cloneBean(personDao);
//			System.out.println(person2.getName()+">>"+person2.getAge());
//			
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//map和bean的互换
		Map<String, String> map = new HashMap<>();  
	    map.put("name","tom");   
	    map.put("age","21");  
	    //将map转化为一个Person对象  
	    PersonDAO person = new PersonDAO();  
	    try {
			BeanUtils.populate(person,map);
			System.out.println(person.getName()+">>"+person.getAge());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    try {
			Map<String, String> map2 = BeanUtils.describe(person);
			System.out.println(map2.get("name")+">>"+map2.get("age"));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
