package com.kh.em.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.em.model.service.EmployeeService;
import com.kh.em.model.vo.Employee;


@WebServlet("/insert.do")
public class InsertEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertEmployee() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("안녕");
		
		// 0) get
		// 1) 전달값
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empNo = request.getParameter("empNo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String deptCode = request.getParameter("deptCode");
		String jobCode = request.getParameter("jobCode");
		String salLevel = request.getParameter("salLevel");
		String salaryStr = request.getParameter("salary");
		int salary = Integer.parseInt(salaryStr);
		
		// 2) 가공 -> vo 클래스를 객체로 생성해서 필드에 담기
		Employee insert = new Employee();
		insert.setEmpId(empId);
		insert.setEmpName(empName);
		insert.setEmpNo(empNo);
		insert.setEmail(email);
		insert.setPhone(phone);
		insert.setDeptCode(deptCode);
		insert.setJobCode(jobCode);
		insert.setSalLevel(salLevel);
		insert.setSalary(salary);
		
		System.out.println(insert.toString());
		
		// 3) 요청 처리 -> Service 호출
		int result = new EmployeeService().insertEmployee(insert);
		
		// 4) 응답 결과 출력
		if(result > 0) {
			// 4_1) 사용자에게 응답 시 출력해줄 데이터가 있다면 세팅
			request.setAttribute("insert", insert);
			
			// 4_2) 응답 뷰 지정
			request.getRequestDispatcher("/WEB-INF/views/insertResult.jsp").forward(request, response);
		} else {
			response.getWriter().append("fail ;(");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
