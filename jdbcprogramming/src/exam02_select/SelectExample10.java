package exam02_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.ConnectionManager;
import dto.Employee;

public class SelectExample10 {

	public static void main(String[] args) {
		//first_name, last_name을 키워드로 검색
		//employee_id, first_name, last_name, department_name
		//city, country_name
		//를 출력
		ConnectionManager.init();
		Scanner sc = new Scanner(System.in);
		System.out.print("키워드 : ");
		String keyword = sc.nextLine();
		List<Employee> list = search(keyword);
		
		for(Employee e : list) {
			System.out.print(e);
			System.out.print("employeeId : " + e.getEmployeeId()+ ", ");
			System.out.print("firstName : " + e.getFirstName()+", ");
			System.out.print("lastName : " + e.getLastName()+", ");
			System.out.print("department_name : " + e.getDepartment().getDepartmentName()+", ");
			System.out.print("city : " + e.getLocation().getCity() +", ");
			System.out.println("countryName : " + e.getCountry().getCountryName());
			System.out.println();
		}
	}
	
	public static List<Employee> search(String keyword){
		Connection conn = null;
		List<Employee> list = new ArrayList();
		try {
			conn = ConnectionManager.getConnection01();
			
			String sql = new StringBuilder()
					.append("select employee_id, first_name, last_name, department_name, city, country_name ")
					.append("from employees e, departments d, locations l, countries c")
					.append("where e.department_id = d.department_id and d.location_id = l.location_id and l.country_id = c.country_id")
					.append("and first_name like ? and last_name like ?")
					.toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee em = new Employee();
				
				em.setEmployeeId(rs.getInt("employee_id"));
				em.setFirstName(rs.getString("first_name"));
				em.setLastName(rs.getString("last_name"));
				em.getDepartment().setDepartmentName(rs.getString("department_name"));
				em.getLocation().setCity(rs.getString("city"));
				em.getCountry().setCountryName(rs.getString("country_name"));
				
				list.add(em);
			}
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
//				System.out.println("연결 끊김");
			} catch (SQLException e) {
			}
		}
		return list;
	}

}
