package exam02_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.dto.Country;
import common.dto.Department;
import common.dto.Employee;
import common.dto.Location;
import common.dto.Region;
import exam01_connect.ConnectionManager;

public class SelectVerify {

	public static void main(String[] args) {
		//first_name, last_name을 키워드로 검색
		//employee_id, first_name, last_name, department_name
		//city, country_name
		//를 출력
		ConnectionManager.init();

		List<Employee> list = search();
		
		System.out.println("------------------------------------------------------------");
		System.out.println("사번       이름            부서이름          직무명           봉급     이메일    전화번호");
		System.out.println("------------------------------------------------------------");
		
		for(Employee e : list) {
			System.out.print(e.getEmployeeId()+ ", ");
			System.out.print(e.getFirstName()+", ");
			System.out.print(e.getLastName()+", ");
			System.out.print(e.getDepartment().getDepartmentName()+", ");
			System.out.print(e.getJobId() + ", ");
			System.out.print(e.getSalary() + ", ");
			System.out.print(e.getEmail() + ", ");
			System.out.println(e.getPhoneNumber());
			System.out.println();
		}
		
		System.out.println("메뉴: 1. 부서 정보 |  2. 근무 지역 | 3. 분석 | 4. 종료");
		Scanner sc = new Scanner(System.in);
		System.out.print("선택 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		select(num);
	}
	
	public static List<Employee> search(){
		Connection conn = null;
		List<Employee> list = new ArrayList();
		
		try {
			conn = ConnectionManager.getConnection01();
			
			String sql = new StringBuilder()
					.append("select employee_id, first_name, last_name, d.department_name, job_id, salary, email, phone_number")
					.append(" from employees e, departments d")
					.append(" where e.department_id = d.department_id order by employee_id")
					.toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee em = new Employee();
				
				em.setEmployeeId(rs.getInt("employee_id"));
				em.setFirstName(rs.getString("first_name"));
				em.setLastName(rs.getString("last_name"));
				
				Department dp = new Department();
				dp.setDepartmentName(rs.getString("department_name"));
				em.setDepartment(dp);
				em.setJobId(rs.getString("job_id"));
				em.setSalary(rs.getDouble("salary"));
				em.setEmail(rs.getString("email"));
				em.setPhoneNumber(rs.getString("phone_number"));
				
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
	

	public static void select(int num){
		Connection conn = null;
		List<Employee> list = new ArrayList();
		int epi;
		Scanner sc = new Scanner(System.in);
		
		try {
			conn = ConnectionManager.getConnection01();
			PreparedStatement pstmt;
			ResultSet rs;
			String sql;
			
			switch(num) {
				case 1:
					
					System.out.print("사번 : ");
					epi = Integer.parseInt(sc.nextLine());
					
					System.out.println("------------------------------------------------------------");
					System.out.println("부서번호         부서이름           관리자명  ");
					System.out.println("------------------------------------------------------------");
					
					sql = new StringBuilder()
							.append("select e.department_id, d.department_name, e1.first_name,e1.last_name ")
							.append("from employees e, departments d, employees e1 ")
							.append("where e.department_id = d.department_id and e1.employee_id = (select manager_id from employees where employee_id = ?) ")
							.append("and e.employee_id = ?")
							.toString();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,epi);
					pstmt.setInt(2,epi);
				
					rs = pstmt.executeQuery();
					Department dp = new Department();
					String name = null;
					
					if(rs.next()) {
						dp.setDepartmentId(rs.getInt("department_id"));
						dp.setDepartmentName(rs.getString("department_name"));
						name = rs.getString("first_name");
						name +=" "+rs.getString("last_name");
						
					}
					System.out.print(dp.getDepartmentId() + ", ");
					System.out.print(dp.getDepartmentName() + ", ");
					System.out.println(name);
					break;
				case 2:
					
					System.out.print("사번 : ");
					epi = Integer.parseInt(sc.nextLine());
					
					System.out.println("------------------------------------------------------------");
					System.out.println("대륙         나라           도시          도로명주소          우편번호");
					System.out.println("------------------------------------------------------------");
					
					sql = new StringBuilder()
							.append("select region_name, country_name, city, street_address, postal_code ")
							.append("from employees e, departments d, locations l, countries c, regions r ")
							.append("where e.department_id = d.department_id and d.location_id = l.location_id ")
							.append("and l.country_id = c.country_id and c.region_id = r.region_id and employee_id = ?")
							.toString();
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,epi);
					rs = pstmt.executeQuery();
					
					Country c = new Country();
					Location l = new Location();
					Region r = new Region();
					
					if(rs.next()) {
						r.setRegionName(rs.getString("region_name"));
						c.setCountryName(rs.getString("country_name"));
						l.setCity(rs.getString("city"));
						l.setStreetAddress(rs.getString("street_address"));
						l.setPostalCode(rs.getString("postal_code"));
					}
					
					System.out.print(r.getRegionName() + ", ");
					System.out.print(c.getCountryName() + ", ");
					System.out.print(l.getCity() + ", ");
					System.out.print(l.getStreetAddress() + ", ");
					System.out.println(l.getPostalCode());
					break;
				case 3:
					System.out.println("------------------------------------------------------------");
					System.out.println("부서명    직무명            직원수      최대봉급    최소봉급     평균봉급");
					System.out.println("------------------------------------------------------------");
					
					sql = new StringBuilder()
							.append("select department_id,job_id, count(employee_id) as ce, max(salary) as maxs, min(salary)as mins, avg(salary) as avgs ")
							.append("from employees ")
							.append("group by department_id, job_id order by department_id, job_id")
							.toString();
					
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					
					while(rs.next()) {
						Employee em = new Employee();
						em.setDepartmentId(rs.getInt("department_id"));
						em.setJobId(rs.getString("job_id"));
						
						int count = rs.getInt("ce");
						double maxs = rs.getDouble("maxs");
						double mins = rs.getDouble("mins");
						double avgs = rs.getDouble("avgs");
						
						System.out.print(em.getDepartmentId() + ", ");
						System.out.print(em.getJobId() + ", ");
						System.out.print(count + ", ");
						System.out.print(maxs + ", ");
						System.out.print(mins + ", ");
						System.out.println(avgs);
					}
					break;
				case 4: 
					System.out.println("종료합니다.");
					break;
			}
			
			
			
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
	}
}
