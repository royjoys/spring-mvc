package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	private static List<Student> students = new ArrayList<Student>();
	private static int count =3;
	static {
		students.add(new Student(1, "Student1", "city1"));
		students.add(new Student(2, "Student2", "city2"));
		students.add(new Student(3, "Student3", "city3"));
		
	}

	
	public List<Student> getAllStudents(){
		return studentDao.getStudents();
	}
	
	public boolean addStudent(Student student){
		//students.add(new Student(count++, student.getName(), student.getCity()));
		studentDao.addStudentJDBC(student);
		return true;
		
	}
}
