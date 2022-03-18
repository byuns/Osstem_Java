package exam02_select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.dto.Employee;


public class SelectExample05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작일 : ");
		String startDate = sc.nextLine();
		System.out.print("종료일 : ");
		String endDate = sc.nextLine();
		
		List<Employee> list = getList(startDate,endDate);
		for(Employee e : list) {
			System.out.print("employee_id : " +e.getEmployeeId()+", ");
			System.out.print("firstName : " +e.getFirstName()+",   \t");
			System.out.print("lastName : " +e.getLastName()+",   \t");
			System.out.print("hireDate : " +e.getHireDate()+"\n");
		}
	}	
		
		public static List<Employee> getList(String startDate, String endDate) {
		Connection conn = null;
		List<Employee> list = new ArrayList();
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
			System.out.println("연결 성공");
			//실행해야할 SQL 작성

			String sql = "select employee_id,first_name,last_name,hire_date,length(first_name) as fl from employees where hire_date between ? and ?";
//			System.out.println(sql);
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate );
			pstmt.setString(2, endDate);
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Employee em = new Employee();
				
				em.setEmployeeId(rs.getInt("employee_id"));
				em.setFirstName(rs.getString("first_name"));
				em.setLastName(rs.getString("last_name"));
				em.setHireDate(rs.getDate("hire_date"));
				int fl = rs.getInt("fl");
				if(fl > 5) {
					em.setFirstName(em.getFirstName().substring(0,5) + "***");
				}
				
				list.add(em);
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
		return list;
		
	}

}
