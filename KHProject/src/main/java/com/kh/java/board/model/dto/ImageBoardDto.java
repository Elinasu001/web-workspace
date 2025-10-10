package com.kh.java.board.model.dto;

import java.util.Objects;

public class ImageBoardDto {
	private Long boardNo;
	private String boardTitle;
	private int count;
	private String filePath;
	private String changeName;
	public ImageBoardDto() {
		super();
	}
	public ImageBoardDto(Long boardNo, String boardTitle, int count, String filePath, String changeName) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.count = count;
		this.filePath = filePath;
		this.changeName = changeName;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(boardNo, boardTitle, changeName, count, filePath);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageBoardDto other = (ImageBoardDto) obj;
		return Objects.equals(boardNo, other.boardNo) && Objects.equals(boardTitle, other.boardTitle)
				&& Objects.equals(changeName, other.changeName) && count == other.count
				&& Objects.equals(filePath, other.filePath);
	}
	@Override
	public String toString() {
		return "ImageBoardDto [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", count=" + count + ", filePath="
				+ filePath + ", changeName=" + changeName + "]";
	}
	
	
	
	
}
