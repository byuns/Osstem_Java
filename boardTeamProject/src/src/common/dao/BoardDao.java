package common.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boardProject.ConnectionManager;
import boardProject.Pager;
import common.dto.Board;

public class BoardDao {
	// select, update, insert, delete와 같은 메소드들로 구성
	
	// Constructor
	
	// 전체 목록 가져오기
	public List<Board> selectAll(Pager pager) {
		List<Board> list = new ArrayList<>();
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();

			String sql = new StringBuilder()
					.append("select rnum, bno, btitle, bwriter, bdate, bcount")
					.append(" from (")
					.append(" 	select rownum as rnum, bno, btitle, bwriter, bdate, bcount")
					.append(" 	from (")
					.append(" 		select bno, btitle, bwriter, bdate, bcount")
					.append(" 		from boards")
					.append(" 		order by bno desc")
					.append(" 	)")
					.append(" 	where rownum <= ?")
					.append(" )")
					.append(" where rnum >= ?").toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getPageNo() * pager.getRowsPerPage());
			pstmt.setInt(2, (pager.getPageNo() - 1) * pager.getRowsPerPage() + 1);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBcount(rs.getInt("bcount"));
				list.add(board);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		
		return list;
	}
	
	// 해당 번호 게시물 가져오기
	public Board selectByBno(int bno,Board board) {
		
		Connection conn = null;
		try {
			// 연결작업, 성공 시 Connection의 구현 객체를 리턴
			conn = ConnectionManager.getConnection();
			
			// 실행해야 할 SQL 작성
			String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata,bpassword,bcount FROM boards WHERE bno=?";
			
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			// SQL을 실행해서 ResultSet 얻기
			ResultSet rs = pstmt.executeQuery();	// sql이 잘못되면 여기서 문제가 발생
			
			// ResultSet에 있는 행의 데이터 읽기, while이나 if를 사용
			if(rs.next()) {	// 행이 하나라면 while을 if로 하면 됨, 없을 수도 있으니 if문으로 검증
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				board.setBpassword(rs.getString("bpassword"));
				board.setBcount(rs.getInt("bcount"));
				
				String sqlCount = "update boards set bcount = bcount+1 where bno = ?";
				PreparedStatement pstmtCount = conn.prepareStatement(sqlCount);
				pstmtCount.setInt(1, bno);
				int rowCount = pstmtCount.executeUpdate();
				pstmtCount.close();
				
				}else {
				System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
			}
			
			// ResultSet과 PreparedStatement가 사용한 메모리 해제
			rs.close();		// ResultSet 사용이 끝났으니 종료
			pstmt.close();	// PreparedStatement 사용이 끝났으니 종료
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		
		return board;
	}

	// 보드 수정
	public int update(Board board) {	// 행이 몇 개 변경되었는지 리턴
		int rows = 0;
		
		Connection conn = null;
		try {
			// 연결작업, 성공 시 Connection의 구현 객체를 리턴
			conn = ConnectionManager.getConnection();
			
			// 실행해야 할 SQL 작성
			String sql = "update boards set btitle=?, bcontent=?";
			sql += (board.getBfilepath() != null) ? ", bfilename=?, bfiledata=?" : "";
			sql += " where bno=?";
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			if(board.getBfilepath() != null) {
				File file = new File(board.getBfilepath());
				pstmt.setString(3, file.getName());
				pstmt.setBlob(4, new FileInputStream(file));
				pstmt.setInt(5, board.getBno());
			} else {
				pstmt.setInt(3, board.getBno());
			}
			
			rows = pstmt.executeUpdate();
			
			pstmt.close();	// PreparedStatement 사용이 끝났으니 종료
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rows;
	}

	// 전체 게시물 수
	public int count() {
		int result = 0;
		
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			String sql = "select count(*) from boards";
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}

			rs.close(); pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		
		return result;
	}

	// 해당 번호 게시물 지우기
	public int deleteByBno(int bno) {
		int result = 0;
		
		Connection conn = null;
		try {
			// 커넥션 대여
			conn = ConnectionManager.getConnection();
			
			// 실행해야 할 SQL 작성
			String sql = "delete from boards where bno=?";
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);			
			
			result = pstmt.executeUpdate();
			
			pstmt.close();	// PreparedStatement 사용이 끝났으니 종료
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 커넥션 반납
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return result;
	}

	
	public int insert(Board board) {
		int result = 0;
		
		Connection conn = null;
		try {
			// 커넥션 대여
			conn = ConnectionManager.getConnection();
			
			// 실행해야 할 SQL 작성
			String sql = "insert into boards values (SEQ_BOARDS_BNO.nextval, ?, ?, ?, sysdate ";
			sql += (board.getBfilepath() != null) ? ", ?, ?" : ",null,?";
			sql += (board.getBpassword() != null) ? ", ? " : ",null";
			sql += ",0)";
			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			if(board.getBfilepath() != null) {
				File file = new File(board.getBfilepath());
				pstmt.setString(4, file.getName());
				pstmt.setBlob(5, new FileInputStream(board.getBfilepath()));
				if(board.getBpassword() != null) {
					pstmt.setString(6, board.getBpassword());
				}
			} else{
				Blob blob = null;
				pstmt.setBlob(4, blob);
				if(board.getBpassword() != null) {
					pstmt.setString(5, board.getBpassword());
				}
			}
			
			
			result = pstmt.executeUpdate();
			
			
			pstmt.close();	// PreparedStatement 사용이 끝났으니 종료
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 커넥션 반납
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return result;
	}
	
	
	// 조회 순으로 정렬하여 가져오기
		public List<Board> selectByBcount(Pager pager) {
			int result = 0;
			List<Board> list = new ArrayList<>();
			Connection conn = null;

			try {
				conn = ConnectionManager.getConnection();

				String sql = new StringBuilder()
						.append("select rnum, bno, btitle, bwriter, bdate, bcount")
						.append(" from (")
						.append(" 	select rownum as rnum, bno, btitle, bwriter, bdate, bcount")
						.append(" 	from (")
						.append(" 		select bno, btitle, bwriter, bdate, bcount")
						.append(" 		from boards")
						.append(" 		order by bcount desc")
						.append(" 	)")
						.append(" 	where rownum <= ?")
						.append(" )")
						.append(" where rnum >= ?").toString();

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pager.getPageNo() * pager.getRowsPerPage());
				pstmt.setInt(2, (pager.getPageNo() - 1) * pager.getRowsPerPage() + 1);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					Board board = new Board();
					board.setBno(rs.getInt("bno"));
					board.setBtitle(rs.getString("btitle"));
					board.setBwriter(rs.getString("bwriter"));
					board.setBdate(rs.getDate("bdate"));
					board.setBcount(rs.getInt("bcount"));
					list.add(board);
					
				}

				rs.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			
			return list;
		}
	


}
