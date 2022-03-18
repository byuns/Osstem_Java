package common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import boardProject.ConnectionManager;
import common.dto.User;

public class UserDao {
User user = null;
	
	public boolean loginVerifying(String userId, String userPassword) {
		boolean userVerfied = false;
		User user = null;
		
		Connection conn = null;
		try {
			// 연결작업, 성공 시 Connection의 구현 객체를 리턴
			conn = ConnectionManager.getConnection();
			
			// 실행해야 할 SQL 작성
			String sql = "SELECT userid, username, userpassword, userage, useremail FROM users WHERE userid=?";
			
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			//System.out.println("??"+userId + "??" + );
			// SQL을 실행해서 ResultSet 얻기
			ResultSet rs = pstmt.executeQuery();	// sql이 잘못되면 여기서 문제가 발생
			
			if(rs.next()) {	// 행이 하나라면 while을 if로 하면 됨, 없을 수도 있으니 if문으로 검증
				user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				if ((user.getUserPassword()).equals(userPassword))
					userVerfied = true;
				else
					System.out.println("비밀번호가 일치하지 않습니다");
			}else {
				System.out.println("가입되지 않은 아이디입니다");
			}
			// ResultSet과 PreparedStatement가 사용한 메모리 해제
			rs.close();		// ResultSet 사용이 끝났으니 종료
			pstmt.close();	// PreparedStatement 사용이 끝났으니 종료
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}	
		return userVerfied;
	}


	public boolean logout() {
		boolean login = false;
		return login;
	}
	
	public boolean signin(User user) {
		boolean signin =false;
		Connection conn = null;
		
		try {	
			conn = ConnectionManager.getConnection();
			
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
			signin=true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception e) {}
		}
		return signin;
	}
	
	public boolean isExist (String userId) {
		boolean isExist = false;
		User user = null;
		
		Connection conn = null;
		try {
			// 연결작업, 성공 시 Connection의 구현 객체를 리턴
			conn = ConnectionManager.getConnection();
			// 실행해야 할 SQL 작성
			String sql = "SELECT userid FROM users WHERE userid=?";
			
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			//System.out.println("??"+userId + "??" + );
			// SQL을 실행해서 ResultSet 얻기
			ResultSet rs = pstmt.executeQuery();	// sql이 잘못되면 여기서 문제가 발생
			if(rs.next()) {	// 행이 하나라면 while을 if로 하면 됨, 없을 수도 있으니 if문으로 검증
				user = new User();
				user.setUserId(rs.getString("userid"));
				if ((user.getUserId()).equals(userId)) {
					isExist = true;
				}
			}
			// ResultSet과 PreparedStatement가 사용한 메모리 해제
			rs.close();		// ResultSet 사용이 끝났으니 종료
			pstmt.close();	// PreparedStatement 사용이 끝났으니 종료
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		return isExist;
	}
}
