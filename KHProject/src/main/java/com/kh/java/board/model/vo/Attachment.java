package com.kh.java.board.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Attachment {
	private Long fileNo;
	private Long refBno; // 어느 게시글에 있는지 알기 위함
	private String originName;
	private String changeName;
	private String filePath; // 일반게시판이냐 사진 게시판이냐
	private Date uploadDate;
	private int fileLevel; // 사진게시판에서만 일반 게시판은 x
	private String status;
	public Attachment() {
		super();
	}
	public Attachment(Long fileNo, Long refBno, String originName, String changeName, String filePath, Date uploadDate,
			int fileLevel, String status) {
		super();
		this.fileNo = fileNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.status = status;
	}
	public Long getFileNo() {
		return fileNo;
	}
	public void setFileNo(Long fileNo) {
		this.fileNo = fileNo;
	}
	public Long getRefBno() {
		return refBno;
	}
	public void setRefBno(Long refBno) {
		this.refBno = refBno;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(changeName, fileLevel, fileNo, filePath, originName, refBno, status, uploadDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attachment other = (Attachment) obj;
		return Objects.equals(changeName, other.changeName) && fileLevel == other.fileLevel
				&& Objects.equals(fileNo, other.fileNo) && Objects.equals(filePath, other.filePath)
				&& Objects.equals(originName, other.originName) && Objects.equals(refBno, other.refBno)
				&& Objects.equals(status, other.status) && Objects.equals(uploadDate, other.uploadDate);
	}
	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refBno=" + refBno + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", fileLevel=" + fileLevel
				+ ", status=" + status + "]";
	}
	
	
	
	
}
