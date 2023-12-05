package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}

	public int update(Student student) {
		// updating data
		String query="update student set name=?,city=? where id=?";
		int result=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return result;
	}

	public int delete(int id) {
		// delete data
		String query="delete from student where id=?";
		int id1=this.jdbcTemplate.update(query,id);
		return id1;
		
	}
	

}
