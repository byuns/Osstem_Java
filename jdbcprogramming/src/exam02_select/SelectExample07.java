package exam02_select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Employee;


public class SelectExample07 {

	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사번 : ");
		int employeeId = Integer.parseInt(sc.nextLine());

		
		List<Employee> list = getEmployee(employeeId);
		for(Employee e : list) {
			/*System.out.print("employeeId : " +e.getEmployeeId()+", ");
			System.out.print("firstName : " +e.getFirstName()+", ");
			System.out.print("lastName : " +e.getLastName()+", ");
			System.out.print("email : " +e.getEmail()+", ");
			System.out.print("phoneNumber : " +e.getPhoneNumber()+", ");
			System.out.print("hireDate : " +e.getHireDate()+", ");
			System.out.print("jobId : " +e.getJobId()+", ");
			System.out.print("salary : " +e.getSalary()+", ");
			System.out.print("commissionPct : " +e.getCommissionPct()+", ");
			System.out.print("managerId : " +e.getManagerId()+", ");
			System.out.print("departmentId : " +e.getDepartmentId()+"\n");*/
			System.out.println(e);
		}
		if(list.size() == 0) {
			System.out.println("해당 사번의 데이터는 존재하지 않습니다.");
		}
		}catch(NumberFormatException e) {
			System.out.println("사번을 입력해주세요.");
		}
	}	
		
		public static List<Employee> getEmployee(int employeeId) {
		Connection conn = null;
		List<Employee> list = new ArrayList();
		try {
			//연결하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
			System.out.println("연결 성공");
			//실행해야할 SQL 작성

			String sql = "select * from employees where employee_id = ?";
//			System.out.println(sql);
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId );
			
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Employee em = new Employee();
				
				em.setEmployeeId(rs.getInt("employee_id"));
				em.setFirstName(rs.getString("first_name"));
				em.setLastName(rs.getString("last_name"));
				em.setEmail(rs.getString("email"));
				em.setPhoneNumber(rs.getString("phone_number"));
				em.setHireDate(rs.getDate("hire_date"));
				em.setJobId(rs.getString("job_id"));
				em.setSalary(rs.getDouble("salary"));
				em.setCommissionPct(rs.getDouble("commission_pct"));
				em.setManagerId(rs.getInt("manager_id"));
				em.setDepartmentId(rs.getInt("department_id"));

				list.add(em);
			}
			//위에서 사용한 메모리 해제
			rs.close();
			pstmt.close();
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(NumberFormatException e) {
				System.out.println("사번을 입력해주세요");
			}
			finally {
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
