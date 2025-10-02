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
			Long userNo = bd.selectBoardWriter(sqlSession, boardNo); // 게시판 수정 / 삭제 버튼 boardWriter도 가져오기 ~~
			
			//System.out.println(board);
			//System.out.println(at);
			// 어딜 담아서 가도 상관 없지만 리스트 : 순서 , set : 중복 없애고 싶을 경우 , map : key, value 명확하게 하고 싶을 경우 [v]
			
			//Map<String, Object> map = Map.of("board", board, "at", at); // put(), remove() 같은 수정 작업 불가능
			
			// 필요하면 이후에 map.put("replyList", replies); 처럼 더 데이터를 추가하거나 변경
			// 가변이라 데이터 추가/수정 가능, 확장성 有
			Map<String, Object> map = new HashMap();
			map.put("board", board);
			map.put("at", at);
			map.put("boardWriter", userNo);
			return map;
		}
		
		return null; // 실패
		
	}
	
	public int deleteBoard(Board board) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bd.deleteBoard(sqlSession, board); // KH_BOARD status 똑같 n으로 변경
																			// long -> int 로 하는 변환 long 메서드
		Attachment at = bd.selectAttachment(sqlSession, board.getBoardNo().intValue());
		// int result2 = 1; 이렇게 하면 안됨, 파일이(at)이 null 일 경우에만 boardNo 여부 확인
		int result2 = 1;
		
		if(at != null) {
			result2 = bd.deleteAttachment(sqlSession, board.getBoardNo()); // KH_ATTACHMENT 파일의 status 똑같 n으로 변경
		}
		
		
		if(result * result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result * result2;
		
	}
	
	public int update(Board board, Attachment at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int boardResult = bd.updateBoard(sqlSession, board); // 파일과는 상관 없이, 게시글 업데이트는 무조건임
		
		// Attachment case 1 ~ 3
		// 새 첨부파일이 없을 때
		int atResult = 1;
		
		// 새 첨부파일이 존재할 경우
		if(at != null) {
			
			// case 1 왜 null 이랑 비교 하지 ? 초기화를 안하면 기본값이 null ** 지역변수는 초기화 안하면 못쓰고 필드는 초기화 안해도 사용 가능 그래서 이것의 참조 자료형은 nul;
			if(at.getFileNo() != null) {
				// 기존에 첨부파일이 있다 => UPDATE
				atResult = bd.updateAttachment(sqlSession, at);
			} else {
				// 기존에 첨부파일이 없다 => INSERT // 만들어 놓은거 사용하기
				atResult = bd.insertAttachment(sqlSession, at);
			}
			
			// case 2
			
		}// 없으면 뭐 할 거 없음
		
		
		// 둘다 성공 했을 때만 commit;
		// 하나라도 실패했으면 rollback;
		if(boardResult * atResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return (boardResult * atResult);
	}
	
	public int searchedCount(Map<String, Object> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = bd.searchedCount(sqlSession, map);
		
		sqlSession.close();
		
		return count;
	}
	
	public List<Board> selectSearchList(Map<String, Object> map) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Board> boards = bd.selectSearchList(sqlSession, map);
		
		sqlSession.close();
		
		return boards;
	}
	
	// 보드는 KH_BOARD (insert) 파일은 KH_ATTACHMENT (insert) 사진게시판은 기존에 있던거 사용할 수 있을까?
	
	public int insertImage(Board board, List<Attachment> files) {
		SqlSession sqlSession = Template.getSqlSession();
		
		// 1. BOARD에 INSERT 하는거 만들어놨음
		// 2. ATTACHMENT에 INSERT하는 거 만들어놨음
		// 1. 일반 게시글 가정으로 boardType이 있다 == 1 / 사진은 == 2 / 사진은 카테고리 없음 ==> 기존에 insert 보트를 못씀
		// 2. ATTACHMENT에 없느 FILE_LEVEL이 있어 기존에 있는건 사용할 수 없다. / REF_NO
		// ==> 결론적으로 다시 새거를 만들어야 한다.
		
		int result = 0;
		
		// insert 하다가 exception이 일어남 ! 예외처리 가자 !
		try {
			
			// 1. 게시글 INSERT 
			result = bd.insertImageBoard(sqlSession, board);
			
			// 2. 게시글에 INSERT가 성공 시 첨부파일을 INSERT
			if(result > 0) {
				
				// 문제 : 첨붚일 개수만큼 INSERT 해야됨 (1개 2개 3개 4개 일수도 있다.)
				for(Attachment file : files) {
					file.setRefBno(board.getBoardNo());
					result = bd.insertAttachmentList(sqlSession, file); // 여기서 예외가 발생하여 실행 안되니 rollback
					
					if(result == 0) { // 중간에 하나라도 실패하면 빠지자
						break;
					}
				}
				
			}
			
			// 3. 다 성공 했으면 commit
			if(result > 0 ) {
				sqlSession.commit();
				
			} else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			
			sqlSession.rollback();
			e.printStackTrace();
			result = 0; // rollback
			
		} finally {
			
			sqlSession.close();
			
		}
		
		return result;
		
	}
	
}
