<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/resources.jsp" %>
<title>Insert title here</title>
</head>
<body>
    <div id="wrap">
        <%@ include file="/WEB-INF/views/include/header.jsp" %>
        <div class="content">
            <div class="tab-wrap">
                <a href="#"  class="tab on">직원 추가</a>
                <a href="/employee/el.do" class="tab ">직원 리스트</a>
            </div>
            <div id="tab1" class="tab-content active">
                <form action="insert.do" method="get">
                    <!--
                        사원아이디 : empId String
                        사원명  : empName String
                        주민등록번호 : empNo String
                        이메일 : email String
                        전화번호 : phone String
                        부서코드 예: D1 : deptCode String ----
                        직급코드 예: J1 :jobCode String
                        급여등급 예: S1 : salLevel String
                        급여 숫자 : salary int
                    -->
                    <fieldset>

                        <div class="input-group mb-3">
                            <span class="input-group-text">사원 아이디</span>
                            <input type="text" class="form-control" name="empId" placeholder="Username" required>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">사원명</span>
                            <input type="text" class="form-control" name="empName"  placeholder="Username" required>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">주민등록번호</span>
                            <input type="text" class="form-control" name="empNo" placeholder="password" required>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">이메일</span>
                            <input type="email" class="form-control" name="email" placeholder="email" required>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">phone</span>
                            <input type="number" class="form-control" name="phone" placeholder="phone" required>
                        </div>
                        
                        <div class="input-group mb-3">
                            <span class="input-group-text">부서코드</span>
                            <select class="form-select" name="deptCode">
                                <option selected>D1</option>
                                <option>D2</option>
                                <option>D3</option>
                                <option>D4</option>
                                <option>D5</option>
                                <option>D6</option>
                                <option>D7</option>
                                <option>D8</option>
                                <option>D9</option>
                            </select>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">직급코드</span>
                            <select class="form-select" name="jobCode">
                                <option selected>J1</option>
                                <option>J2</option>
                                <option>J3</option>
                                <option>J4</option>
                                <option>J5</option>
                                <option>J6</option>
                                <option>J7</option>
                                <option>J8</option>
                                <option>J9</option>
                            </select>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">급여등급</span>
                            <select class="form-select" name="salLevel">
                                <option selected>S1</option>
                                <option>S2</option>
                                <option>S3</option>
                                <option>S4</option>
                                <option>S5</option>
                                <option>S6</option>
                                <option>S7</option>
                                <option>S8</option>
                                <option>S9</option>
                            </select>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">급여</span>
                            <input type="text" class="form-control" name="salary"  placeholder="salary">
                        </div>
                        
                        <div class="btn-wrap">
	                        <button type="submit" class="btn btn-primary">추가하기</button>
	                        <button type="reset" class="btn btn-secondary">초기화</button>
                        </div>
                    </fieldset>
                    
                </form>
            </div>
            
            <div id="tab2" class="tab-content">
				
            </div>
        </div>
    </div>
</body>

</html>