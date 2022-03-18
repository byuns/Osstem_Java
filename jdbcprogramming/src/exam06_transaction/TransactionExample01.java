package exam06_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import exam01_connect.ConnectionManager;

public class TransactionExample01 {
	public static void main(String[] args) {
		ConnectionManager.init();
		Connection conn = null;
		
		try {
			
			conn = ConnectionManager.getConnection02();
			
			conn.setAutoCommit(false);
			
			//출금 작업
			String sql1 = "update accounts set balance=balance-10000 where ano='111-111-1111'";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.executeUpdate();
			
			
			//입금 작업
			String sql2 = "update accounts2 set balance=balance+10000 where ano='222-222-2222'";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeUpdate();
			pstmt2.close();
			
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch(Exception e2) {e.printStackTrace();}
			e.printStackTrace();
		}finally {
			try {
					conn.setAutoCommit(true);
					conn.close();
				}catch(Exception e) {}
		}
	}
}
