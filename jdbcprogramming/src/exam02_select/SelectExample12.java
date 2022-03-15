package exam02_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.ConnectionManager;
import dto.Country;
import dto.Department;
import dto.Employee;
import dto.Location;
import dto.Region;

public class SelectExample12 {
	//Field
	private Scanner scanner;
	private Pager pager;
	
	//Constructor
	public SelectExample12() {
		scanner = new Scanner(System.in);
		ConnectionManager.init();
		pager = new Pager(10, 5, getTotalRows(), 1);
	}
	
	//Method
	
	public void start() {
		while(true) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("ID\tFirstName\tLastName\tDepartmentName\tJobId\tSalary\tTel\tEmail");
			System.out.println("--------------------------------------------------------------");

			List<Employee> list = list();
			for(Employee e : list) {
				System.out.print(e.getEmployeeId() + "\t");
				System.out.print(e.getFirstName() + "\t");
				System.out.print(e.getLastName() + "\t");
				System.out.print(e.getDepartment().getDepartmentName() + "\t");
				System.out.print(e.getJobId() + "\t");
				System.out.print(e.getSalary() + "\t");
				System.out.print(e.getPhoneNumber() + "\t");
				System.out.print(e.getEmail() + "\t");
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------");
			System.out.print("[First]");
			System.out.print((pager.getGroupNo()) >= 2 ? "[Prev] " : "");
			for(int i = pager.getStartPageNo(); i <= pager.getEndPageNo(); i++) {
				if(i == pager.getPageNo()) {
					System.out.print("("+ i + ")" + ((i != pager.getEndPageNo())?", ":""));
				} else {
					System.out.print(i+ ((i != pager.getEndPageNo())?", ":""));
				}
			}
			System.out.print((pager.getGroupNo()) < pager.getTotalGroupNo() ? " [Next] " : "");
			System.out.println("[Last]");
			
			System.out.println("자세히 보기 위한 메뉴는 d, 페이지 선택은 m을 입력해주세요.");
			System.out.print("선택 : ");
			String select = scanner.nextLine();
			
			if(select.equals("d") || select.equals("D")) {
				selectDetail();
			}else if(select.equals("m") || select.equals("M")) {
				System.out.println("선택 : ");
				select = scanner.nextLine();
				if(select.equals("f") || select.equals("F")) {
					getFirstPage();
				} else if(select.equals("p") || select.equals("P")){
					getPrevGroup();
				} else if(select.equals("n") || select.equals("N")){
					getNextGroup();
				} else if(select.equals("l") || select.equals("L")){
					getLast();
				} else {
					getPage(Integer.parseInt(select));
				}
			}else {
				System.out.println("올바르게 입력해주세요.");
			}
		}
	}
	
	
	private void selectDetail() {
		System.out.println("메뉴: 1. 부서 정보 |  2. 근무 지역 | 3. 분석 | 4. 종료");
		Scanner sc = new Scanner(System.in);
		System.out.print("선택 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		select(num);
	}
	
	private void select(int num){
		Connection conn = null;
		List<Employee> list = new ArrayList();
		int epi;
		Scanner sc = new Scanner(System.in);
		
		Pager detailPager = new Pager(10, 5, getTotalRowsDetail(), 1);
		
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
					
					System.out.println("이전 페이지로 가기 위해 아무 키나 눌러주세요.");
					String tmp1 = sc.nextLine();
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
					
					System.out.println("이전 페이지로 가기 위해 아무 키나 눌러주세요.");
					String tmp2 = sc.nextLine();
					break;
					
				case 3:
					boolean run = true;
					while(run) {
						System.out.println("------------------------------------------------------------");
						System.out.println("부서명    직무명            직원수      최대봉급    최소봉급     평균봉급");
						System.out.println("------------------------------------------------------------");
					
						sql = new StringBuilder()
								.append("select rnum,department_id,job_id, ce,maxs,mins,avgs  ")
								.append("from(select rownum as rnum, department_id,job_id, ce,maxs,mins,avgs ")
								.append("from (")
								.append("        select department_id,job_id, count(employee_id) as ce, max(salary) as maxs, min(salary) as mins, avg(salary) as avgs")
								.append("        from employees")
								.append("        group by department_id, job_id order by department_id, job_id")
								.append("	)")
								.append("    where rownum <= ?)")
								.append(" where rnum >= ?")
								.toString();
					
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, detailPager.getPageNo()*detailPager.getRowsPerPage());
						pstmt.setInt(2, (detailPager.getPageNo()-1)*detailPager.getRowsPerPage() + 1);
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
						
						System.out.print("[First]");
						System.out.print((detailPager.getGroupNo()) >= 2 ? "[Prev] " : "");
						for(int i = detailPager.getStartPageNo(); i <= detailPager.getEndPageNo(); i++) {
							if(i == detailPager.getPageNo()) {
								System.out.print("("+ i + ")" + ((i != detailPager.getEndPageNo())?", ":""));
							} else {
								System.out.print(i+ ((i != detailPager.getEndPageNo())?", ":""));
							}
						}
						System.out.print((detailPager.getGroupNo()) < detailPager.getTotalGroupNo() ? " [Next] " : "");
						System.out.println("[Last]");

						System.out.println("선택 : ");
						String select = sc.nextLine();
						if(select.equals("f") || select.equals("F")) {
							detailPager = new Pager(10, 5, getTotalRowsDetail(), 1);
						} else if(select.equals("p") || select.equals("P")){
							detailPager = new Pager(10, 5, getTotalRowsDetail(), detailPager.getStartPageNo() - 1);
						} else if(select.equals("n") || select.equals("N")){
							detailPager = new Pager(10, 5, getTotalRowsDetail(), detailPager.getEndPageNo() + 1);
						} else if(select.equals("l") || select.equals("L")){
							detailPager = new Pager(10, 5, getTotalRowsDetail(), detailPager.getTotalPageNo());
						} else if(select.equals("exit") || select.equals("EXIT")) {
							run = false;
						}else {
							detailPager = new Pager(10, 5, getTotalRowsDetail(), Integer.parseInt(select));
						}
					}
					System.out.println("이전 페이지로 가기 위해 아무 키나 눌러주세요.");
					String tmp3 = sc.nextLine();
					break;
				case 4: 
					System.out.println("종료합니다.");
					break;
			}
					

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
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
	
	
	private static int getTotalRows() {
		int result = 0;
			Connection conn = null;		
		
		try {
			conn = ConnectionManager.getConnection01();
			
			String sql = "select count(*)from employees";
			        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}	
		}
		return result;
	}
	
	
	
	private static int getTotalRowsDetail() {
		int result = 0;
			Connection conn = null;		
		
		try {
			conn = ConnectionManager.getConnection01();
			
			String sql = "select count(*)\r\n"
					+ "from (\r\n"
					+ "    select department_id,job_id, count(employee_id), max(salary) as maxs, min(salary)as mins, avg(salary)\r\n"
					+ "    from employees\r\n"
					+ "    group by department_id, job_id order by department_id, job_id\r\n"
					+ "    )";
			        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}	
		}
		return result;
	}
	
	
	private List<Employee> list() {
		List<Employee> result = new ArrayList<>();

		Connection conn = null;		
		
		try {
			conn = ConnectionManager.getConnection01();
			String sql = new StringBuilder()
					.append("select rnum, employee_id, first_name, last_name, department_name, job_id, salary, phone_number, email ")
					.append("from ( ")
					.append("	select rownum as rnum, employee_id, first_name,department_name, last_name, job_id, salary, phone_number, email ")
					.append("	from ( ")
					.append("		select employee_id, first_name, last_name,department_name, job_id, salary, phone_number, email ")
					.append("		from employees e, departments d where e.department_id = d.department_id")
					.append("		order by employee_id desc ")
					.append("	) ")
					.append("	where rownum <= ? ")
					.append(") ")
					.append("where rnum >= ? ")
					.toString();
			        
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getPageNo()*pager.getRowsPerPage());
			pstmt.setInt(2, (pager.getPageNo()-1)*pager.getRowsPerPage() + 1);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("employee_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				
				Department dp = new Department();
				dp.setDepartmentName(rs.getString("department_name"));
				employee.setDepartment(dp);
				
				employee.setJobId(rs.getString("job_id"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				employee.setEmail(rs.getString("email"));
			    
				result.add(employee);    
			}
			
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}	
		}
		return result;
	}
	
	private void getFirstPage() {
		pager = new Pager(10, 5, getTotalRows(), 1);
	}
	
	private void getPrevGroup() {
		pager = new Pager(10, 5, getTotalRows(), pager.getStartPageNo() - 1);
	}
	
	private void getPage(int pageNo) {
		pager = new Pager(10, 5, getTotalRows(), pageNo);
	}

	private void getNextGroup() {
		pager = new Pager(10, 5, getTotalRows(), pager.getEndPageNo() + 1);
	}

	private void getLast() {
		pager = new Pager(10, 5, getTotalRows(), pager.getTotalPageNo());
	}

	public static void main(String[] args) {
		SelectExample12 exam = new SelectExample12();
		exam.start();
	}

}