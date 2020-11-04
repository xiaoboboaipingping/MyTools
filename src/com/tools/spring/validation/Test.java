package com.tools.spring.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Test {
	
	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
 
		User user = new User();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for (ConstraintViolation<User> constraintViolation : constraintViolations) {
			System.out.println("对象属性:"+constraintViolation.getPropertyPath());
			System.out.println("国际化key:"+constraintViolation.getMessageTemplate());
			System.out.println("错误信息:"+constraintViolation.getMessage());
		}
	}

}
