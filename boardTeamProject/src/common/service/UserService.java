package common.service;

import java.util.Scanner;

import common.dao.UserDao;
import common.dto.User;

public class UserService {
	private UserDao userDao = new UserDao();
	Scanner sc = new Scanner(System.in);
	User user = new User();
	
	// 로그인 login
	public User isLogined() {
		String uId = null;
		String uPassword = null;
		System.out.println("아이디를 입력해주세요: ");
		uId = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요: ");
		uPassword = sc.nextLine();
		if(userDao.loginVerifying(uId, uPassword)) {
			return userDao.getUser(uId);
		}else {
			return null;
		}
	}
	// 로그아웃 logout
	public User islogout() {
		return userDao.logout();
	}
	
	// 회원가입 signUp
		public boolean isSignin() {
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
				
				if(userDao.isIdExist(user.getUserId())) {
					System.out.println("이미 존재하는 아이디입니다.");
					return false;
				} else {
					boolean rnt = false;
					if(rnt = userDao.signin(user))
					System.out.println("회원가입 완료");
					return rnt;
				}
			}
		}
		
		//회원탈퇴 signOut
		public boolean isSignout() {
			String uId = null;
			String uPassword = null;
			System.out.println("아이디를 입력해주세요: ");
			uId = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요: ");
			uPassword = sc.nextLine();
			
			if(userDao.isUserExist(uId, uPassword)) {
				System.out.println("회원탈퇴 완료");
				return userDao.signout(uId);
			}else {
				System.out.println("회원 정보가 일치하지 않습니다.");
				return false;
			}
		}
}
