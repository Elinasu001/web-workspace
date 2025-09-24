package com.kh.em.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.em.model.vo.Employee;

public class EmployeeDao {
		
	
	public int insertEmployee(SqlSession session, Employee insert) {
		return session.insert("employeeMapper.insertEmployee", insert);
	}
	
	public List<Employee> findAll(SqlSession session){
		return session.selectList("employeeMapper.findAll");
	}
	
}
