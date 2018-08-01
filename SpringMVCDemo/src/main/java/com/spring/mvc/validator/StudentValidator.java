package com.spring.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.mvc.model.Student;

@Component
public class StudentValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.city", "City is Required");
		/*if(!student.getCity().equalsIgnoreCase("Bangalore")){
			errors.rejectValue("city", "error.city", "City Should be Bangalore");
		}*/
	}

}
