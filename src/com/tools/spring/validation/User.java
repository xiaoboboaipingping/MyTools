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
	
	@Length(min = 2, max = 6, message = "用户名长度要求在{min}-{max}之间")
    @NotNull(message = "用户名不可为空")
    private String userName;
	
	@Email(message = "邮箱格式错误")
    private String email;

    @Past(message = "出生日期错误")
    private Date birthDay;

    @Min(value = 18, message = "年龄错误")
    @Max(value = 80, message = "年龄错误")
    private Integer age;

    @Range(min = 0, max = 1, message = "性别选择错误")
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
