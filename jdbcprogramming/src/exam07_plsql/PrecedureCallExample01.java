package exam07_plsql;
/*
create or replace procedure board_create(
    
    p_btitle    in boards.btitle%type,
    p_bcontent  in boards.bcontent%type,
    p_bwriter   in boards.bwriter%type,
    p_bfilename in boards.bfilename%type,
    p_bfiledata in boards.bfiledata%type,
    
    p_rows      out pls_integer
) as 
begin
    insert into boards
    values(seq_boards_bno.nextval,p_btitle,p_bcontent,p_bwriter,sysdate,p_bfilename, p_bfiledata);
    p_rows  := sql%rowcount;
    commit;
end board_create;
*/
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import exam01_connect.ConnectionManager;

public class PrecedureCallExample01 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionManager.getConnection02();
			
			//프로시저 호출 문자열 
			String sql = "{call board_create(?,?,?,?,?,?)}";
			
			//프로시저 호출할 CallableStatment 얻기
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// ? 값과 용도 설정
			cstmt.setString(1,"테스트");
			cstmt.setString(2,"내용");
			cstmt.setString(3, "user2");
			File file = new File("C:/Temp/images/photo1.jpg");
			cstmt.setString(4, file.getName());
			cstmt.setBlob(5, new FileInputStream("C:/Temp/images/photo1.jpg"));
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
