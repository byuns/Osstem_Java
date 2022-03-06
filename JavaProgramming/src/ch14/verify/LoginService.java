package ch14.verify;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LoginService {
	private List<IdPassword> signUpList = new ArrayList();
	private Scanner sc = new Scanner(System.in);

	
	public void singUp() throws Exception{
		String id;
		String password;
		
		System.out.println("회원 가입을 진행합니다.");
		while(true) {
			boolean flag = false;
			
			System.out.print("아이디를 입력해주세요 : ");
			id = sc.nextLine();
			for(IdPassword signUp : signUpList) {
				if(signUp.getId().equals(id)) {
					System.out.println("동일한 아이디가 존재합니다.\n다시 입력해주세요.");
					flag = true;
					break;
				}
			}
			if(flag == true) {
				continue;
			}else {
				if( id.replace(" ", "").equals("") || id.contains(" ") ) {
					System.out.println("아이디는 공백이 불가합니다.");
				}else {
					break;
				}
			}
		}
		while(true) {
			System.out.print("비밀번호를 입력해주세요.(6자리) : ");
			password = sc.nextLine();
			if(password.length() != 6) {
				System.out.println("6자리 비밀번호를 입력해주세요.");
			}
			else if(password.replace(" ", "").equals("") || password.contains(" ")) {
				System.out.println("비밀번호는 공백이 불가합니다.");
			}else {
				break;
			}
		}
		signUpList.add(new IdPassword(id,password));
		FileOutputStream fos = new FileOutputStream("C:/Temp/loginData.db");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(signUpList);
		oos.flush();
		oos.close();
	}

	public String Login() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/loginData.db");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<IdPassword> list = (List<IdPassword>)ois.readObject();
		
		System.out.println("로그인을 합니다. 아이디와 비밀번호를 입력해주세요.");
		boolean flag = true;
		
		while(flag) {
			System.out.print("ID : ");
			String id = sc.nextLine();
		
			for(IdPassword ip : list) {
				if(ip.getId().equals(id)) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				System.out.println("아이디가 존재하지 않습니다. \n다시 입력해주세요.");
			}
		}
		
		while(true) {
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			for(IdPassword ip : list) {
				if(ip.getPassword().equals(password)) {
					System.out.print("로그인 되었습니다.");
					ois.close();
					return ip.getId(); // 로그인한 id 리턴
				}
			}
				System.out.println("비밀번호가 틀렸습니다. \n다시 입력해주세요.");
		}	
	}
	
	public void Logout() throws Exception {
		Login();
	}
}
