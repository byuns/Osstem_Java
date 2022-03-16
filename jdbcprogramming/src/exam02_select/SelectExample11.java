package exam02_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Employee;
import exam01_connect.ConnectionManager;

public class SelectExample11 {
	//Field
	private Scanner scanner;
	private Pager pager;
	
	//Constructor
	public SelectExample11() {
		scanner = new Scanner(System.in);
		ConnectionManager.init();
		pager = new Pager(10, 5, getTotalRows(), 1);
	}
	
	//Method
	
	public void start() {
		while(true) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("ID\tFirstName\tLastName\tJobId\tTel\tEmail");
			System.out.println("--------------------------------------------------------------");

			List<Employee> list = list();
			for(Employee e : list) {
				System.out.print(e.getEmployeeId() + "\t");
				System.out.print(e.getFirstName() + "\t");
				System.out.print(e.getLastName() + "\t");
				System.out.print(e.getJobId() + "\t");
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
			System.out.println("선택 : ");
			String select = scanner.nextLine();
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
		}
	}
	
	private int getTotalRows() {
		int result = 0;
			Connection conn = null;		
		
		try {
			conn = ConnectionManager.getConnection02();
			
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
	
	private List<Employee> list() {
		List<Employee> result = new ArrayList<>();

		Connection conn = null;		
		
		try {
			conn = ConnectionManager.getConnection02();
			String sql = new StringBuilder()
					.append("select rnum, employee_id, first_name, last_name, job_id, phone_number, email ")
					.append("from ( ")
					.append("	select rownum as rnum, employee_id, first_name, last_name, job_id, phone_number, email ")
					.append("	from ( ")
					.append("		select employee_id, first_name, last_name, job_id, phone_number, email ")
					.append("		from employees ")
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
				employee.setJobId(rs.getString("job_id"));
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
		SelectExample11 exam = new SelectExample11();
		exam.start();
	}

}