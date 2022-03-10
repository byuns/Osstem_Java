package exam02_select;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class SelectExample02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키워드 : ");
		String keyWord = sc.nextLine();
		
		
		Connection conn = null;
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
			System.out.println("연결 성공");
			//실행해야할 SQL 작성
			keyWord = keyWord.toLowerCase();
			String sql = "select employee_id,first_name,last_name from employees where lower(first_name) like ?"
					+ "or lower(last_name) like '%" + keyWord + "%'";
//			System.out.println(sql);
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyWord +"%");
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				
				System.out.println(employee_id +"\t"+ first_name+"\t"+ last_name);
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
