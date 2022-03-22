package exam07_plsql;
/*
create or replace procedure user_create 
(
  p_userid          in users.userid%type,
  p_username        in users.username%type,
  p_userpassword    in users.userpassword%type,
  p_userage         in users.userage%type,
  p_useremail       in users.useremail%type,
  p_rows            out pls_integer
) as 
begin
  insert into users 
  values(p_userid, p_username, p_userpassword, p_userage, p_useremail);
  p_rows  := sql%rowcount;
  commit;
end user_create;

*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import exam01_connect.ConnectionManager;

public class PrecedureCallExample02 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionManager.getConnection02();
			
			//프로시저 호출 문자열 
			String sql = "{call user_create(?,?,?,?,?,?)}";
			
			//프로시저 호출할 CallableStatment 얻기
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// ? 값과 용도 설정
			cstmt.setString(1,"user2");
			cstmt.setString(2,"사용자2");
			cstmt.setString(3, "12345");
			cstmt.setInt(4,25);
			cstmt.setString(5, "user2@company.com");
			cstmt.registerOutParameter(6, Types.INTEGER);
			
			//프로시저 호출
			cstmt.execute();
			
			//OUT 파라미터 값 얻기 
			int rows = cstmt.getInt(6);
			System.out.println("저장된 행 수 : " + rows);
			
			//CallableStatement 닫기
			cstmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}

	}

}
