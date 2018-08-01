package com.spring.mvc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.model.Student;

@Component
public class StudentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	DataSource datasource;
	
	JdbcTemplate jdbcTemplate;
	
	public DataSource getDatasource() {
		return datasource;
	}

	@Autowired
	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public List<Student> getStudents(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Student").list();
	}
	
	@Transactional
	public void addStudent(Student student){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	public boolean addStudentJDBC(Student student){
		String sql = "insert into Student(name,city) values (?,?)";
		
		Object[] args = new Object[]{student.getName(),student.getCity()}; 	
		int output = this.jdbcTemplate.update(sql, args);
		return output != 0? true:false;
	}
	
}
