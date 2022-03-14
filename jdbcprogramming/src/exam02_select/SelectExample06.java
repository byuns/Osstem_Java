package exam02_select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SelectExample06 {

	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();

		
		//로그인 처리
		String result = login(email,password);
		if(result.equals("success")) {
			System.out.println("로그인 성공");
		}else if(result.equals("wrongEmail")) {
			System.out.println("이메일이 존재하지 않습니다.");
		}else if(result.equals("wrongPassword")) {
			System.out.println("비밀번호가 틀립니다.");
		}
	}
	
	public static String login(String email, String password) {
		Connection con = null;
		String result = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
			System.out.println("연결 성공");
			
			String sql = "select first_name from employees where email = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,email);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("first_name");
				if(pw.equals(password)) {
					result = "success";
				}else {
					result = "wrongPassword";
				}
			}else {
				result = "wrongEmail";
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//연결 끊기
			try {
				con.close();
				System.out.println("연결 끊김");
			} catch (SQLException e) {
			}
		}
		return result;
	}
}
