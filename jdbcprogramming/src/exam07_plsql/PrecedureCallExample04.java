package exam07_plsql;

/*
create or replace procedure get_board (
    p_bno   in boards.bno%type,
    p_board out sys_refcursor
)as 
begin
    open p_board for 
    select bno, btitle,bcontent, bwriter, bdate, bfilename, bfiledata
    from boards
    where bno = p_bno;
end get_board;
*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import common.dto.Board;
import exam01_connect.ConnectionManager;

public class PrecedureCallExample04 {

	public static void main(String[] args) {
		ConnectionManager.init();
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionManager.getConnection02();
			
			//프로시저 호출 문자열 
			String sql = "{call get_board(?,?)}";
			
			//프로시저 호출할 CallableStatment 얻기
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// ? 값과 용도 설정
			cstmt.setInt(1,23);
			cstmt.registerOutParameter(2, Types.REF_CURSOR);
			
			//프로시저 시홸
			cstmt.execute();
			
			//OUT 파라미터 값 얻기 
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				System.out.println(board);
			}
			rs.close();
			
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
