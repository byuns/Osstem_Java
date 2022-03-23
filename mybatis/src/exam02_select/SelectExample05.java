package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;
import dto.Pager;

public class SelectExample05 {
	public static void main(String[] args) {
		
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			
			//방법 1 ----------------------------------------
			//BoardDao의 메소드 호출
			//Board board = boardDao.selectBoardWithUser1(12);
			
			//방법 2 ----------------------------------------
			Board board = session.selectOne("dao.BoardDao.selectBoardWithUser2",12);
			
			//리턴값 출력
			System.out.println(board);
			System.out.println(board.getBtitle());
			System.out.println(board.getUser().getUserName());
			System.out.println(board.getUser().getUserEmail());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
