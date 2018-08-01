package com.spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.model.Student;
import com.spring.mvc.service.StudentService;
import com.spring.mvc.validator.StudentValidator;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@Autowired
	StudentValidator validator;
	
	@RequestMapping(value="/student/showStudents", method=RequestMethod.GET)
	public String showStudents(ModelMap model){
		
			//throw new RuntimeException();
		//if(showStudent)
			List<Student> students = service.getAllStudents(); 
			model.addAttribute("students", students);
			return "students";
			
			//else{
			
			//}}
		
	}
	
	@RequestMapping(value="/student/addStudent", method=RequestMethod.GET)
	public String gotoAddStudentPage(ModelMap model){
		model.addAttribute("student",new Student());
		return "student";
	}
	
	@RequestMapping(value="/student/addStudent", method=RequestMethod.POST)
	public String addStudent(ModelMap model,@ModelAttribute Student student,  BindingResult result){
		System.out.println("Student=="+student);
		validator.validate(student, result);
		if(result.hasErrors()){
			return "student"; 
		}
		else {
			if(service.addStudent(student)){
				return "redirect:/student/showStudents";
			} else {
				return "user";
			}
		}
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(HttpServletRequest req, Exception ex){
		System.out.println("URL:"+req.getRequestURL()+" caused "+ex.getMessage());
		return "error1";
		
	}

}

