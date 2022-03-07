package ch14.verify01;

import java.io.*;

public class User implements Serializable{ // 객체 입출력 보조 스트림 사용을 위한 Serializable 구현

  // 필드
	private String id; // 아이디
	private String password; // 비밀번호

  // User 생성자
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

  // getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}