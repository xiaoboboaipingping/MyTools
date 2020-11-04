package com.tools.commons.beanutils;

public class PersonDAO {
	private String name;
	private int age;
	
	public PersonDAO(){
		
	}
	
	public PersonDAO(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonDAO [name=" + name + ", age=" + age + "]";
	}
	
}
