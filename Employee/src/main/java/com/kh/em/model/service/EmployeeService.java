package com.kh.em.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.em.common.Template;
import com.kh.em.model.dao.EmployeeDao;
import com.kh.em.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDao ed = new EmployeeDao();
	
	public int insertEmployee(Employee insert) {
		
		SqlSession session = Template.getSqlSession();
		
		int result = ed.insertEmployee(session, insert);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	};
	
	public List<Employee> findAll(){
		SqlSession session = Template.getSqlSession();
		
		List<Employee> empList = ed.findAll(session);
		
		session.close();
		
		return empList;
	}
}
