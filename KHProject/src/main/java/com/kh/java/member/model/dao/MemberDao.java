package com.kh.java.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.member.model.vo.Member;

public class MemberDao {
	
	public Member login(SqlSession sqlSession, Member member) {
		// 로그인 성공했을 경우 화면에 보여지는게 무엇인지? 그럼 어떤 값을 들고가야되는지? 생각하기
		return sqlSession.selectOne("memberMapper.login", member);
	}
	
	public int signUp(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}
	
	public int update(SqlSession sqlSession, Map<String, String> map) {
		return sqlSession.update("memberMapper.update", map);
	}
	
	public int delete(SqlSession sqlSession, Member member) {
		return sqlSession.update("memberMapper.delete", member);
	}
	
	public int updatePwd(SqlSession sqlSession, Map<String, String> map) {
		return sqlSession.update("memberMapper.updatePwd", map);
	}
	
	public String checkId(SqlSession sqlSession, String id) {
		return sqlSession.selectOne("memberMapper.checkId", id);
	}
	
}
