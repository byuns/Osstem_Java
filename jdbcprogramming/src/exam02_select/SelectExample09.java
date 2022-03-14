package exam02_select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.ConnectionManager;


public class SelectExample09 {
	public static void main(String[] args) throws Exception {
		
		ConnectionManager.init();
		Thread[] threads = new Thread[100];
		long start = System.nanoTime();
		for(int i=0;i<100;i++) {
			threads[i] = new Thread() {
				@Override
				public void run() {
					printSalary();
				}
			};
			threads[i].start();
		}
		for(int j=0; j<100; j++) {
			threads[j].join();
		}
		long end = System.nanoTime();
		long time = end-start;
		System.out.println(time + "ns");
	}

	public static void printSalary() {
		Connection conn = null;
		try {
			//연결하기
			conn = ConnectionManager.getConnection01();
//			System.out.println("연결 성공");
			//실행해야할 SQL 작성
			String sql = "select employee_id, salary *nvl(commission_pct,0) from employees where employee_id = ?";
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 100);
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				double yearsal = rs.getDouble(2);
				Thread thread = Thread.currentThread();
				System.out.println(thread.getName() + ", "+employee_id +"\t"+ yearsal);
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
//					System.out.println("연결 끊김");
				} catch (SQLException e) {
				}
			}
		
	}

}
