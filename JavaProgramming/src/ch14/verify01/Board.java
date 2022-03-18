package ch14.verify01;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{//하나의 보드
	private int bno; //게시물 번호
	private String title; // 게시물 제목
	private String writer; // 게시물 글쓴이
	private Date date; // 게시물 작성 일자
	private String content; // 게시물 내용
	private String boardPassword; // 게시물 비밀번호
	private boolean open; // 게시글 공개 비공개
	

	public Board(int bno, String title, String writer, String content, Date date, boolean open) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.open = open;//추가
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBoardPassword() {
		return boardPassword;
	}
	public void setBoardPassord(String boardPassword) {
		this.boardPassword = boardPassword;
	}
  public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
}
