package com.kh.em.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.em.model.service.EmployeeService;
import com.kh.em.model.vo.Employee;

@WebServlet("/el.do")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Employee> empList = new EmployeeService().findAll();
		
		request.setAttribute("empList", empList);
		
		 request.getRequestDispatcher("/WEB-INF/views/employee/employeeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
