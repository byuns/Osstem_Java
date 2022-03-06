package ch14.verify01;

import java.io.*;
import java.util.*;

public class UserService {
	
	List<User> userList = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	// 회원가입
	public void signUp() throws Exception {
		String newId = null;
		String newPwd = null;
		
		User newUser = null;
		
		boolean idChk = chkId();
		while(true) {
			if(idChk) {
				System.out.print("아이디 : ");
				newId = sc.nextLine();
				for(User user : userList) {
					if(newId.equals(user.getId())) {
						System.out.println("존재하는 아이디입니다.");
					} else if(newId.replace(" ", "").equals("")) {
						System.out.println("아이디를 입력해 주세요.");
					} else {
						idChk = false;
						break;
					}
					break;
				}
			} else {
				break;
			}
		}
		
		while(true) {
			System.out.print("비밀번호 : ");
			newPwd = sc.nextLine();
			if(newPwd.replace(" ", "").equals("")) {
				System.out.println("비밀번호를 입력해주세요.");
			} else {
				break;
			}
		}
		
		newUser = new User(newId, newPwd);
		userList.add(newUser);
		FileOutputStream fos = new FileOutputStream("C:/Temp/project/test.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(userList);
		oos.flush();
		oos.close();
		
		System.out.println("회원가입 완료");
	}	
	
	// 로그인
	public String loginUser() throws Exception {
		
		callId();
		String nowUser = null;
		System.out.print("아이디 : " );
		String loginId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String loginPwd = sc.nextLine();
		if(loginId.replace(" ","").equals("")) {//로그인 공백처리시 
			System.out.println("로그인창을 빠져나갑니다.");
			nowUser = "back";
		}else {//로그인 입력시
			for(User user : userList) {
				if(loginId.equals(user.getId()) && loginPwd.equals(user.getPassword())) {
					System.out.println(loginId + "님 환영합니다.");
					nowUser = loginId;//로그인 됨
					break;
				} else if(loginId.equals(user.getId()) && !loginPwd.equals(user.getPassword())) {
					System.out.println("비밀번호가 틀렸습니다.");
					nowUser = "pwd";
					break;						
				} 
			}
			if(nowUser == null) {
				System.out.println("존재하지 않는 아이디입니다.");
			}
			
		}
		
		return nowUser;//결과 전송
	}
	
	public boolean chkId() throws Exception {
		
		File file = new File("C:/Temp/project/test.db");
		if(file.exists() == false) {//파일 없으면
			file.createNewFile();
			return false;
		} else {//파일 존재하면
			FileInputStream fis = new FileInputStream("C:/Temp/project/test.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			userList = (List<User>) ois.readObject();
			return true;
		}
		
	}

  public void callId() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/project/test.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		userList = (List<User>) ois.readObject();
	}
}
