package service;

import java.util.Scanner;

import dao.UserDao;
import dto.User;

public class UserService {
	Scanner sc = new Scanner(System.in);
	User user = new User();
	
	public User isLogined(UserDao userDao) {
		String uId = null;
		String uPassword = null;
		System.out.println("아이디를 입력해주세요: ");
		uId = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요: ");
		uPassword = sc.nextLine();
		if(userDao.loginVerifying(uId, uPassword) != null) {
			return userDao.getUser(uId);
		}else {
			System.out.println("입력 정보가 잘못 입력되었습니다.\n다시 입력해주세요.");
			return null;
		}
	}
	
	// 로그아웃 logout
		public User islogout(UserDao userDao) {
			return null;
		}
		
		// 회원가입 signUp
			public boolean isSignin(UserDao userDao) {
				while(true) {
					System.out.print("userId : ");
					user.setUserId(sc.nextLine());
					System.out.print("userName : ");
					user.setUserName(sc.nextLine());
					System.out.print("userPassword : ");
					user.setUserPassword(sc.nextLine());
					try {
						System.out.print("userAge : ");
						user.setUserAge(Integer.parseInt(sc.nextLine()));
					} catch(NumberFormatException e) {
						System.out.println("나이 형식은 숫자로 이루어져야 합니다.");
						return false;
					}
					System.out.print("userEmail : ");
					user.setUserEmail(sc.nextLine());
					
					if(userDao.isIdExist(user.getUserId()) != null) {
						System.out.println("이미 존재하는 아이디입니다.");
						return false;
					} else {
						
						if(userDao.signin(user) != 0)
						System.out.println("회원가입 완료");
						
						return true;
					}
				}
			}
			//회원탈퇴 signOut
			public boolean isSignout(UserDao userDao) {
				String uId = null;
				String uPassword = null;
				System.out.println("아이디를 입력해주세요: ");
				uId = sc.nextLine();
				System.out.println("비밀번호를 입력해주세요: ");
				uPassword = sc.nextLine();
				
				if(userDao.isUserExist(uId, uPassword) != null) {
					System.out.println("회원탈퇴 완료");
					return true;
				}else {
					System.out.println("회원 정보가 일치하지 않습니다.");
					return false;
				}
			}

}
