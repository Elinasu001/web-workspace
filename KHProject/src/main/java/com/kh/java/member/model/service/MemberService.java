package com.kh.java.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.member.common.Template;
import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.Member;

public class MemberService {
	
	private MemberDao md = new MemberDao();
	
	
	/**
	 * @param member
	 * 
	 * 로그인 메소드
	 */
	public Member login(Member member) {
		// 로그인 처리 -> Dao 에 보내서 있나 없다 -> 결과값 반환
		// validateMember(member); // 책임 분리하여 로직을 분리 한다. // 비지니스 로직
		
		// SqlSession 을 여기다가 하는 이유는 ? transaction 하기 위함
		// => 예) 게시글 insert 2 번 실행 ( 게시글 작성, 첨부파일 ) 두개를 하나의 트랜잭션으로 묶어서 처리
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
		
		
	}
	
	// 분리된 로직은 원래 다른 페이지로 ! 일단, 이 페이지로 진행
	public void validateMember(Member member) {
		// ★★★★★★★★★
		// [ 아이디 검증 로직 ]
		// 아이디 : 값이 없거나 space 로 들어 올 경우
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		// 아이디 :  값이 있는데 문자로 들어올 경우
		String pattern = "^[a-zA-Z0-9] {4,20}$";
		if(!member.getUserId().matches(pattern)) {
			return;
		}
		// [ 비밀번호 검증 로직 ]
	}
	
	
}
