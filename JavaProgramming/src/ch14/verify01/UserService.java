package ch14.verify01;
import java.io.*;
import java.util.*;

public class UserService {
	
	List<User> userList = new ArrayList<>(); // User를 저장하기위한 ArrrayList 선언
	
	Scanner sc = new Scanner(System.in); // 스캐너 사용
	
	// 회원가입 메소드
	public void signUp() throws Exception {
		String newId = null; // 새로운 아이디를 입력받기 위한 변수
		String newPwd = null; // 새로운 비밀번호를 입력받기 위한 변수

		User newUser = null; // 객체를 저장하기 위한 User 타입의 변수 설정
		
		boolean flag = false;
		
		String[] tmpStr  = null;
		
		boolean idChk = chkId();
		if(idChk != false) {
			tmpStr = new String[userList.size()];
			for(int i=0; i<userList.size(); i++) {
				tmpStr[i] = userList.get(i).getId();
			}
		}
		
		while (true) { // 무한 루프
			if (idChk) { // 가입된 아이디가 있는 경우
				System.out.print("아이디 : ");
				newId = sc.nextLine(); // 아이디를 입력 받는다
				for(int i=0; i<tmpStr.length; i++) {
					for(String s : tmpStr) {
						if(s.equals(newId)) {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					System.out.println("존재하는 아이디입니다.");
					break;
				} else if (newId.replace(" ", "").equals("")) {
					System.out.println("아이디를 입력해 주세요.");
				} else {
					System.out.print("비밀번호 : ");
					newPwd = sc.nextLine();
					if (newPwd.replace(" ", "").equals("")) {
						System.out.println("비밀번호를 입력해주세요.");
					} else {
						System.out.println("회원가입 완료");		
						newUser = new User(newId, newPwd);
						userList.add(newUser);
						FileOutputStream fos = new FileOutputStream("C:/Temp/project/user.db");
						ObjectOutputStream oos = new ObjectOutputStream(fos);

						oos.writeObject(userList);
						oos.flush();
						oos.close();

						break;
					}	
				}
			} else {
				System.out.print("아이디 : ");
				newId = sc.nextLine();
				if (newId.replace(" ", "").equals("")) {
					System.out.println("아이디를 입력해 주세요.");
				}
				System.out.print("비밀번호 : ");
				newPwd = sc.nextLine();
				if (newPwd.replace(" ", "").equals("")) {
					System.out.println("비밀번호를 입력해주세요.");
				} else {
					System.out.println("회원가입 완료");
					newUser = new User(newId, newPwd);
					userList.add(newUser);
					FileOutputStream fos = new FileOutputStream("C:/Temp/project/user.db");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(userList);
					oos.flush();
					oos.close();

					break;
				}
				break;
			}

		}
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
		
		File file = new File("C:/Temp/project/user.db");
		if(file.exists() == false) {//파일 없으면
			file.createNewFile();
			return false;
		} else {//파일 존재하면
			FileInputStream fis = new FileInputStream("C:/Temp/project/user.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			userList = (List<User>) ois.readObject();
			return true;
		}
		
	}

  public void callId() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/project/user.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		userList = (List<User>) ois.readObject();
	}
}


//	      while(true){
//	        System.out.print("[ 로그인 ] (회원 가입 y) ");
//	        String signUp = sc.nextLine();
//	        if(signUp.equals("y")){
//	          System.out.println("[ 회원가입 ]");
//	          userService.signUp();
//	          System.out.println("[ 로그인 ]");
//	          login = userService.loginUser();          
//	        } else{
//	          login = userService.loginUser();
//	        }
//	      }