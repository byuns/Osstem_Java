package common.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.dto.Board;
import exam01_connect.ConnectionManager;
import exam02_select.Pager;

public class BoardDao {

	public List<Board> selectAll(Pager pager){
		List<Board> list = new ArrayList();
		
		Connection conn = null;		
		Board board = null;
		
		try {
			conn = ConnectionManager.getConnection02();
			String sql = new StringBuilder()
					.append("select rnum, bno, btitle,bcontent ,bwriter, bdate,bfilename ")
					.append("from ( ")
					.append("	select rownum as rnum, bno, btitle, bcontent,bwriter, bdate ,bfilename")
					.append("	from ( ")
					.append("		select bno, btitle,bcontent, bwriter, bdate,bfilename ")
					.append("		from boards ")
					.append("		order by bno desc ")
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
				if(rs.next()) {
					board = new Board(); 
					
					board.setBno(rs.getInt("bno"));
					board.setBtitle(rs.getString("btitle"));
					board.setBcontent(rs.getString("bcontent"));
					board.setBwriter(rs.getString("bwriter"));
					board.setBdate(rs.getDate("bdate"));
					board.setBfilename(rs.getString("bfilename"));
					list.add(board);
				}
					
			}
			
			rs.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (SQLException e) {}	
		}
		
		return list;
	}
	
	public Board selectByBno(int bno) {
		Board board = null;
		Connection conn = null;
		try {
			//연결하기
			conn = ConnectionManager.getConnection01();
			//실행해야할 SQL 작성
			String sql = "Select bno,btitle,bcontent,bwriter,bdate,bfilename,bfiledata from boards where bno = ?";
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				board = new Board(); 
				
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
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
				} catch (SQLException e) {}
			}
		
		
		return board;
	}
	
	public int update(Board board){
		
		int rows = 0;
		
		Connection conn = null;
		try {
			//연결하기
			conn = ConnectionManager.getConnection02();
			//실행해야할 SQL 작성
			String sql = "update boards set btitle = ?, bcontent = ?";
			sql += (board.getBfilepath() != null) ? ", bfilename = ?, bfiledata = ?" : "";
			sql += " where bno = ?";
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			
			if(board.getBfilepath() != null) {
				File file =new File(board.getBfilepath());
				pstmt.setString(3, file.getName());
				pstmt.setBlob(4, new FileInputStream(file));
				pstmt.setInt(5, board.getBno());
			}else {
				pstmt.setInt(3, board.getBno());
			}
			// SQL을 실행해서 결과 얻기
			rows = pstmt.executeUpdate();

			//위에서 사용한 메모리 해제
			
			pstmt.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//연결 끊기
				try {
					conn.close();
					
				} catch (SQLException e) {}
			}
	
		return rows;
	}


	public int count() {
		int result = 0;
		
		Connection conn = null;
		try {
			//연결하기
			conn = ConnectionManager.getConnection02();
			//실행해야할 SQL 작성
			String sql = "select count(*) from boards";
			
			// SQL를 실행할 PrepareStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			// SQL을 실행해서 결과 얻기
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			//위에서 사용한 메모리 해제
			
			pstmt.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//연결 끊기
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		
		
		return result;
	}
	

	
}
