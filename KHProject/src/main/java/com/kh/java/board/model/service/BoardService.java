package com.kh.java.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.board.model.vo.Category;
import com.kh.java.common.vo.PageInfo;
import com.kh.java.member.common.Template;

public class BoardService {
	private BoardDao bd = new BoardDao();
	
	public int selectListCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = bd.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public List<Board> selectBoardList(PageInfo pi){
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Board> boards = bd.selectBoardList(sqlSession, pi);
		
		sqlSession.close();
		
		return boards;
	}
	
	public List<Category> selectCategory(){
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Category> categories = bd.selectCategory(sqlSession);
		
		sqlSession.close();
		
		return categories;
	}
	
	public void insert(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// INSERT를 두 번 수행
		
		
		// BOARD 테이블에 한 번  --> 무조건 가서 INERT 해야됨
		int boardResult = bd.insertBoard(sqlSession, board);
		
		// ATTACHMENT 테이블에 한 번 --> 파일을 첨부 유무에 따른 INSERT (즉, 파일 존재 시)
		
		
		// 두 개의 DML 구문을 하나의 트랜잭션으로 묶어서 처리
		
		// 트랜잭션 처리까지 끝내고 난 후 성공실패 여부를 반환
		
	}
	
}
