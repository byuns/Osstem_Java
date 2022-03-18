package exam03_insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.dto.User;
import exam01_connect.ConnectionManager;

public class InsertExample01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
		
		Connection conn = null;
		try {
			
			conn = ConnectionManager.getConnection02();
			
			String sql = "insert into users(userid, username, userpassword, userage,useremail)"
					+ "values(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setInt(4, user.getUserAge());
			pstmt.setString(5, user.getUserEmail());
			
			int rows = pstmt.executeUpdate();
			
			
			pstmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception e) {}
		}
		
	}

}
