package exam03_insert;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class InsertExample01 {

	public static void main(String[] args) {
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			Board board = new Board();
			board.setBtitle("오늘은 흐려요");
			board.setBcontent("공부하기 정말 좋은 날씨네요.");
			board.setBwriter("spring");
			//방법 1 ----------------------------------------
			//BoardDao boardDao = session.getMapper(BoardDao.class);
			//int rows = boardDao.insertBoard(board);
					
			//방법 2 ---------------------------------------
			int rows = session.insert("dao.BoardDao.insertBoard",board);
			
			//리턴값 출력
			System.out.println("저장된 행 수 : " + rows);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
