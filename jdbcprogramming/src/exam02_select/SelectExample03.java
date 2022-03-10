package exam02_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class SelectExample03 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
			System.out.println("연결 성공");
			//실행해야할 SQL 작성
			String sql = "select employee_id, salary *nvl(commission_pct,0) from employees";
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				double yearsal = rs.getDouble(2);
				
				System.out.println(employee_id +"\t"+ yearsal);
			}
			//위에서 사용한 메모리 해제
			rs.close();
			pstmt.close();
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//연결 끊기
				try {
					conn.close();
					System.out.println("연결 끊김");
				} catch (SQLException e) {
				}
			}
		
	}

}
