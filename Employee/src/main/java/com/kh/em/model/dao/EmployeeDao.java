package com.kh.em.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.em.model.vo.Employee;

public class EmployeeDao {
		
	
	public int insertEmployee(SqlSession session, Employee insert) {
		return session.insert("insertMapper.insertEmployee", insert);
	}
	
}
