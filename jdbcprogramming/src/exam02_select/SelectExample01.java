package exam02_select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class SelectExample01 {

	public static void main(String[] args) {
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
			System.out.println("연결 성공");
			//실행해야할 SQL 작성
			String sql = "Select employee_id, email, salary, hire_date From employees";
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String email = rs.getString("email");
				double salary = rs.getDouble("salary");
				Date hire_date = rs.getDate("hire_date");
				
				System.out.println(employee_id + "\t" + email + "    \t" +salary +"\t"+ hire_date);
			}
			//위에서 사용한 메모리 해제
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("연결 끊김");
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

}
