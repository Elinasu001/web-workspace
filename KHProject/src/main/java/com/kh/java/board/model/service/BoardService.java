package com.kh.java.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public int insert(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// INSERT를 두 번 수행
		
		
		// BOARD 테이블에 한 번  --> 무조건 가서 INERT 해야됨
		int boardResult = bd.insertBoard(sqlSession, board);
		
		// ATTACHMENT 테이블에 한 번 --> 파일을 첨부 유무에 따른 INSERT (즉, 파일 존재 시)
		/*
			insertAttachment() 자체가 실행되지 않음
	
			그럼 atResult 는 기본값 0으로 남음
			
			그러면 조건문에서 atResult > 0 체크가 실패 → rollback 발생
			
			즉, 첨부파일 없는 정상적인 케이스도 "실패"로 처리돼 버림
			
			그래서 첨부파일 없는 경우 atResult = 1 : atResult 를 1로 세팅 : 자동으로 성공 처리
		
		 */
		
		int atResult = 1; // 첨부파일이 없을 때도 커밋이 진행되도록 기본값을 1로 설정
		if(at != null) {
			// 첨부파일 객체(at)가 존재할 경우,
		    // 방금 INSERT 된 게시글 번호(boardNo)를 첨부파일의 참조 번호(refBno)에 세팅한다.
		    // => 어떤 게시글에 첨부파일이 속하는지 연결(외래키 관계)하기 위함
			at.setRefBno(board.getBoardNo());
			atResult = bd.insertAttachment(sqlSession, at);
		}
		
		// 두 개의 DML 구문을 하나의 트랜잭션으로 묶어서 처리
		// boardResult * 1 > 0 → 정상적으로 성공 처리
		if(boardResult * atResult > 0 ) { // ==  (boardResult > 0) && (atResult > 0)
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		// 트랜잭션 처리까지 끝내고 난 후 성공실패 여부를 반환
		return (boardResult * atResult);
	}
	
	public Map<String, Object> selectBoard(int boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// SELECT 두 번 하기 + 조회수 증가 (COUNT -> UPDATE)
		// 그럼 총 3번 DB 가야 된다.
		// UPDATE BOARD => COMMIT -- UPDATE 실패하면 굳이 조회하러 SELECT BOARD 안가도 됨
		// SELECT BOARD	=> COMMIT 했을 때만 밑에 작업들을 하면 된다.
		// SELECT ATTACHMENT
		
		
		int result = bd.increaseCount(sqlSession, boardNo);
		
		if(result > 0) { // 성공	// 실제로는 쿼리부터 가야됨
			
			sqlSession.commit();
			Board board = bd.selectBoard(sqlSession, boardNo);
			Attachment at = bd.selectAttachment(sqlSession, boardNo);
			//System.out.println(board);
			//System.out.println(at);
			// 어딜 담아서 가도 상관 없지만 리스트 : 순서 , set : 중복 없애고 싶을 경우 , map : key, value 명확하게 하고 싶을 경우 [v]
			
			//Map<String, Object> map = Map.of("board", board, "at", at); // put(), remove() 같은 수정 작업 불가능
			
			// 필요하면 이후에 map.put("replyList", replies); 처럼 더 데이터를 추가하거나 변경
			// 가변이라 데이터 추가/수정 가능, 확장성 有
			Map<String, Object> map = new HashMap();
			map.put("board", board);
			map.put("at", at);
			
			return map;
		}
		
		return null; // 실패
		
	}
	
}
