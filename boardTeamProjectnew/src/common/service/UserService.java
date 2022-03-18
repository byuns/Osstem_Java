package common.service;

import java.util.Scanner;

import common.dao.UserDao;
import common.dto.User;

public class UserService {
	private UserDao userDao = new UserDao();
	Scanner sc = new Scanner(System.in);
	
	// 로그인 login
	public boolean isLogined() {
		String uId = null;
		String uPassword = null;
		System.out.println("아이디를 입력해주세요: ");
		uId = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요: ");
		uPassword = sc.nextLine();
		return userDao.loginVerifying(uId, uPassword);
	}
	// 로그아웃 logout
	public boolean islogout() {
		return userDao.logout();
	}
	
	// 회원가입 signUp
	public boolean isSignin() {
		User user = new User();
		System.out.print("userId : ");
		user.setUserId(sc.nextLine());
		System.out.print("userName : ");
		user.setUserName(sc.nextLine());
		System.out.print("userPassword : ");
		user.setUserPassword(sc.nextLine());
		System.out.print("userAge : ");
		user.setUserAge(Integer.parseInt(sc.nextLine()));
		System.out.print("userEmail : ");
		user.setUserEmail(sc.nextLine());
		if(userDao.isExist(user.getUserId())) {
			System.out.println("이미 존재하는 아이디입니다.");
			return false;
		}else {
			System.out.println("회원가입 완료");
			return userDao.signin(user);
		}
	}
	
	//회원탈퇴 signOut
}
