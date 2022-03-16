package exam03_insert;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dto.Board;
import exam01_connect.ConnectionManager;

public class InsertExample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Board board = new Board();
		System.out.print("btitle : ");
		board.setBtitle(sc.nextLine());
		System.out.print("bcontent : ");
		board.setBcontent(sc.nextLine());
		System.out.print("bwriter : ");
		board.setBwriter(sc.nextLine());
		System.out.print("filepath : ");
		board.setBfilepath(sc.nextLine());
		
		
		Connection conn = null;
		try {
			
			conn = ConnectionManager.getConnection02();
			
			String sql = "insert into boards(bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata)\r\n"
					+ "values(SEQ_BOARDS_BNO.nextval, ?,?,?,sysdate,?,?)";
			
			//시퀀스가 적용된 컬럼을 가져오도록 컬럼명을 추가
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			
			if(!board.getBfilepath().equals("")) {
				File file = new File(board.getBfilepath());
				pstmt.setString(4,file.getName());
				pstmt.setBlob(5, new FileInputStream(board.getBfilepath()));
				
			}else {
				pstmt.setString(4,null);
				Blob blob = null;
				pstmt.setBlob(5, blob);
			}
			int rows = pstmt.executeUpdate();
			
			//시퀀스가 적용된 컬럼 값 얻기
			ResultSet rs = pstmt.getGeneratedKeys(); // "bno"를 가져옴
			if(rs.next()) {
				int bno = rs.getInt(1);
				System.out.println("저장된 bno : " + bno);
			}
			rs.close();
			pstmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {conn.close();}catch(Exception e) {}
		}
		
	}

}
