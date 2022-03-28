package exam05_delete;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class DeleteExample01 {

	public static void main(String[] args) {
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			int bno = 8;
			//방법 1 ----------------------------------------
			BoardDao boardDao = session.getMapper(BoardDao.class);
			int rows = boardDao.deleteBoard(bno);
			//방법 2 ---------------------------------------
			//int rows= session.delete("dao.BoardDao.deleteBoard",bno);
			
			//리턴값 출력
			System.out.println("삭제된 행 수 : " + rows);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
