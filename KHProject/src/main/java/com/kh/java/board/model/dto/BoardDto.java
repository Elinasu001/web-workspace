package com.kh.java.board.model.dto;

import java.util.List;
import java.util.Objects;

import com.kh.java.board.model.vo.Attachment;

public class BoardDto {
	
	private Long boardNo;
	private String boardWriter;   // 작성자
	private String boardTitle;
	private String boardContent;
	private List<Attachment> files;

	// 기본 생성자
	public BoardDto() {
		super();
	}

	// 전체 필드를 포함한 생성자
	public BoardDto(Long boardNo, String boardWriter, String boardTitle, String boardContent, List<Attachment> files) {
		super();
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.files = files;
	}

	// Getter / Setter
	public Long getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public List<Attachment> getFiles() {
		return files;
	}

	public void setFiles(List<Attachment> files) {
		this.files = files;
	}

	// equals & hashCode
	@Override
	public int hashCode() {
		return Objects.hash(boardNo, boardWriter, boardTitle, boardContent, files);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BoardDto other = (BoardDto) obj;
		return Objects.equals(boardNo, other.boardNo)
				&& Objects.equals(boardWriter, other.boardWriter)
				&& Objects.equals(boardTitle, other.boardTitle)
				&& Objects.equals(boardContent, other.boardContent)
				&& Objects.equals(files, other.files);
	}

	// toString
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo 
				+ ", boardWriter=" + boardWriter 
				+ ", boardTitle=" + boardTitle 
				+ ", boardContent=" + boardContent 
				+ ", files=" + files + "]";
	}
}
