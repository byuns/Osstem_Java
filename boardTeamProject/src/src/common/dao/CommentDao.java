package common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boardProject.ConnectionManager;
import boardProject.Pager;
import common.dto.Comment;

public class CommentDao {

	// 특정 게시물 리스트 전부 가져오기
	public List<Comment> selectAll(Pager pager) {
		List<Comment> list = new ArrayList<>();
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();

			String sql = new StringBuilder()
					.append("select rownum as rnum, cno, ccontent, cdate, cwriter, bno")
					.append(" from (")
					.append(" 	select rownum as rnum, cno, ccontent, cdate, cwriter, bno")
					.append(" 	from (")
					.append(" 		select cno, ccontent, cdate, cwriter, bno")
					.append(" 		from comments")
					.append(" 		order by cno")
					.append(" 	)")
					.append(" 	where rownum <= ?")
					.append(" )").append(" where rownum >= ?")
					.toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pager.getPageNo() * pager.getRowsPerPage());
			pstmt.setInt(2, (pager.getPageNo() - 1) * pager.getRowsPerPage() + 1);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCno(rs.getInt("cno"));
				comment.setCcontent(rs.getString("ccontent"));
				comment.setCdate(rs.getDate("cdate"));
				comment.setCwriter(rs.getString("cwriter"));
				list.add(comment);
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

	// 특정 게시물 번호의 댓글 페이징해서 가져오기
	public List<Comment> selectByBno(int bno, Pager pager) {
		List<Comment> list = new ArrayList<>();

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();

			// SELECT cno, ccontent, cdate, cwriter, bno FROM comments WHERE bno=?
			String sql = new StringBuilder()
					.append("select rownum as rnum, cno, ccontent, cdate, cwriter, bno")
					.append(" from (")
					.append(" 	select rownum as rnum, cno, ccontent, cdate, cwriter, bno")
					.append(" 	from (")
					.append(" 		select cno, ccontent, cdate, cwriter, bno")
					.append(" 		from comments")
					.append(" 		where bno=?")
					.append(" 		order by cdate")
					.append(" 	)")
					.append(" 	where rownum <= ?")
					.append(" )")
					.append(" where rnum >= ?").toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setInt(2, pager.getPageNo() * pager.getRowsPerPage());
			pstmt.setInt(3, (pager.getPageNo() - 1) * pager.getRowsPerPage() + 1);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) { 
				Comment comment = new Comment();
				comment.setCno(rs.getInt("cno"));
				comment.setCcontent(rs.getString("ccontent"));
				comment.setCdate(rs.getDate("cdate"));
				comment.setCwriter(rs.getString("cwriter"));
				comment.setBno(rs.getInt("bno"));
				list.add(comment);
			}

			rs.close(); // ResultSet 사용이 끝났으니 종료
			pstmt.close(); // PreparedStatement 사용이 끝났으니 종료
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}

		return list;
	}

	// 특정 게시물의 갯수
	public int count(int bno) {
		int result = 0;

		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			String sql = "select count(*) from comments where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
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

		return result;
	}

	// 댓글 쓰기
	public int insert(Comment comment) {
		int result = 0;

		Connection conn = null;
		try {
			// 커넥션 대여
			conn = ConnectionManager.getConnection();

			// 실행해야 할 SQL 작성
			// cno, ccontent, cdate, cwriter, bno
			String sql = "insert into comments values(SEQ_BOARDS_CNO.nextval, ?, sysdate, ?, ?)";

			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getCcontent()); // test
			pstmt.setString(2, comment.getCwriter()); // test
			pstmt.setInt(3, comment.getBno()); // test

			result = pstmt.executeUpdate();

			pstmt.close(); // PreparedStatement 사용이 끝났으니 종료
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

	// 댓글 삭제
	public int delete(Comment deleteComment) {
		int result = 0;

		Connection conn = null;
		try {
			// 커넥션 대여
			conn = ConnectionManager.getConnection();

			// 실행해야 할 SQL 작성
			// cno, ccontent, cdate, cwriter, bno
			String sql = "delete from comments where cno=? and bno=?";

			// SQL을 실행할 PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deleteComment.getCno()); // test
			pstmt.setInt(2, deleteComment.getBno()); // test

			result = pstmt.executeUpdate();

			pstmt.close(); // PreparedStatement 사용이 끝났으니 종료
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

}
