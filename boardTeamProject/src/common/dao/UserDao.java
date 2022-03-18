package common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import boardProject.ConnectionManager;
import common.dto.User;

public class UserDao {
	
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

	public User getUser(String userId) {
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
				user.setUserAge(rs.getInt("userage"));
				user.setUserEmail(rs.getString("useremail"));
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
		return user;
	}
	
	public User logout() {
		User user = null;
		return user;
	}
	
	public boolean signin(User user) {
		boolean signin = false;
		Connection conn = null;
		//아이디, 이름, 비밀번호는 영어, 숫자 형식
		//이메일은 xxx@xxx.xxx 형식
		String wordPattern = "^[a-zA-Z0-9]+$";
		String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		
		try {	
			conn = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO USERS(userid, username, userpassword, userage,useremail)"
					+ "VALUES(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setInt(4, user.getUserAge());
			pstmt.setString(5, user.getUserEmail());
			
			//형식 비교
			boolean regex1 = Pattern.matches(wordPattern, user.getUserId());
			boolean regex2 = Pattern.matches(wordPattern, user.getUserName());
			boolean regex3 = Pattern.matches(wordPattern, user.getUserPassword());
			boolean regex4 = Pattern.matches(emailPattern, user.getUserEmail());
			
			//각 값이 false일 때
			if(!regex1) {
				System.out.println("아이디 형식은 영어, 숫자로 이루어져야 합니다.");
			}else if(!regex2) {
				System.out.println("이름 형식은 영어, 숫자로 이루어져야 합니다.");
			}else if(!regex3) {
				System.out.println("비밀번호 형식은 영어, 숫자로 이루어져야 합니다.");
			}else if(!regex4) {
				System.out.println("이메일은 @와 .이 포함되어야 합니다.");
			}else if(regex1 && regex2 && regex3 && regex4) {
				
				int rows = pstmt.executeUpdate();
				
				pstmt.close();
				signin=true;
			}
		}catch(SQLException e) {
			System.out.println("입력 내용이 너무 깁니다.\n다시 입력해주세요.");
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception e) {}
		}
		return signin;
	}
	
	public boolean signout(String userId) {
		boolean signout = false;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			String sql = "DELETE FROM users WHERE userId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			signout = true;
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception e) {}
		}
		return signout;
	}
	
	public boolean isIdExist (String userId) {
		boolean isIdExist = false;
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
					isIdExist = true;
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
		return isIdExist;
	}
	
	public boolean isUserExist (String userId, String userPassword) {
		boolean isUserExist = false;
		User user = null;
		
		Connection conn = null;
		try {
			// 연결작업, 성공 시 Connection의 구현 객체를 리턴
			conn = ConnectionManager.getConnection();
			// 실행해야 할 SQL 작성
			String sql = "SELECT userid, userpassword FROM users WHERE userid=? and userpassword=?";
			
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPassword);
			
			//System.out.println("??"+userId + "??" + );
			// SQL을 실행해서 ResultSet 얻기
			ResultSet rs = pstmt.executeQuery();	// sql이 잘못되면 여기서 문제가 발생
			if(rs.next()) {	// 행이 하나라면 while을 if로 하면 됨, 없을 수도 있으니 if문으로 검증
				user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserPassword(rs.getString("userpassword"));
				if ((user.getUserId()).equals(userId) && (user.getUserPassword()).equals(userPassword)) {
					isUserExist = true;
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
		return isUserExist;
	}
}
