package com.koreait.vo;

import java.sql.Date;

public class FileUploadVO {

	private String id;
	private String fileName;
	private String fileSubject;
	private String fileContent;
	private int fileSize;
	private String fileType;
	private Date writeDate;
	private int filePoint;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSubject() {
		return fileSubject;
	}
	public void setFileSubject(String fileSubject) {
		this.fileSubject = fileSubject;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getFilePoint() {
		return filePoint;
	}
	public void setFilePoint(int filePoint) {
		this.filePoint = filePoint;
	}
	
	@Override
	public String toString() {
		return "MvcboardVO [id=" + id + ", fileName=" + fileName + ", fileSubject=" + fileSubject + ", fileContent="
				+ fileContent + ", fileSize=" + fileSize + ", fileType=" + fileType + ", writeDate=" + writeDate
				+ ", filePoint=" + filePoint + "]";
	}
	
}