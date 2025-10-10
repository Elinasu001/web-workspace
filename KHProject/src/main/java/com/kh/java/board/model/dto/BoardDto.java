package com.kh.java.board.model.dto;

import java.util.List;
import java.util.Objects;

import com.kh.java.board.model.vo.Attachment;

public class BoardDto {
	
	private Long boardNo;
	private String boardTitle;
	private String boardContent;
	private List<Attachment> files;
	public BoardDto() {
		super();
	}
	public BoardDto(Long boardNo, String boardTitle, String boardContent, List<Attachment> files) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.files = files;
	}
	public Long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
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
	@Override
	public int hashCode() {
		return Objects.hash(boardContent, boardNo, boardTitle, files);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDto other = (BoardDto) obj;
		return Objects.equals(boardContent, other.boardContent) && Objects.equals(boardNo, other.boardNo)
				&& Objects.equals(boardTitle, other.boardTitle) && Objects.equals(files, other.files);
	}
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", files=" + files + "]";
	}
	
	
	
}
