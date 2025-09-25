package com.kh.java.member.model.vo;

import java.util.Date;
import java.util.Objects;

public class Member {
	/*
		USER_NO NUMBER PRIMARY KEY,
		USER_ID VARCHAR2(30) UNIQUE NOT NULL, // varchar2는 무조건 String
		USER_PWD VARCHAR2(30) NOT NULL,
		USER_NAME VARCHAR(20) NOT NULL,
		EMAIL VARCHAR2(30) NOT NULL,
		ENROLL_DATE DATE DEFAULT SYSDATE, -- 가입시간
		MODIFY_DATE DATE DEFAULT SYSDATE, -- 수정한 시간
		STATUS CHAR(1) DEFAULT 'Y' CHECK(STATUS IN ('Y', 'N'))
	 */
	// { primitive : 0; } { wrapperClass: null; }
	// PK일 경우 생각해보자!
	// int(절반밖에 못씀) vs Long(v : 사용자가 많기 때문)
	// long(primitive) vs Long(wrapper)(v : why? 프레임워크의 호환성)
	private Long userNo;
	private String userId;	
	private String userPwd;
	private String userName;
	private String email;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	public Member() {
		super();
	}
	public Member(Long userNo, String userId, String userPwd, String userName, String email, Date enrollDate,
			Date modifyDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, enrollDate, modifyDate, status, userId, userName, userNo, userPwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(email, other.email) && Objects.equals(enrollDate, other.enrollDate)
				&& Objects.equals(modifyDate, other.modifyDate) && Objects.equals(status, other.status)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName)
				&& Objects.equals(userNo, other.userNo) && Objects.equals(userPwd, other.userPwd);
	}
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
	
	
}
