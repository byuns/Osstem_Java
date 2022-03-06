package pro.exam;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{//하나의 보드
	private int bno; //게시물 번호
	private String title; // 게시물 제목
	private String writer; // 게시물 글쓴이
	private Date date; // 게시물 작성 일자
	private String content; // 게시물 내용
	private String boardPassword; // 게시물 비밀번호
	

	public Board(int bno, String title, String writer, String content, Date date) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
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
}
