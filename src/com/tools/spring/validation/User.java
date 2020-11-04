package com.tools.spring.validation;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class User {
	private String id;
	
	@Length(min = 2, max = 6, message = "�û�������Ҫ����{min}-{max}֮��")
    @NotNull(message = "�û�������Ϊ��")
    private String userName;
	
	@Email(message = "�����ʽ����")
    private String email;

    @Past(message = "�������ڴ���")
    private Date birthDay;

    @Min(value = 18, message = "�������")
    @Max(value = 80, message = "�������")
    private Integer age;

    @Range(min = 0, max = 1, message = "�Ա�ѡ�����")
    private Integer sex;

	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	

	public String getUserName() {
		return userName;
	}
	

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Date getBirthDay() {
		return birthDay;
	}
	

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	

	public Integer getAge() {
		return age;
	}
	

	public void setAge(Integer age) {
		this.age = age;
	}
	

	public Integer getSex() {
		return sex;
	}
	

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
    
    
	
}
