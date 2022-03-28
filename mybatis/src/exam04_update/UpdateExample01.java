package exam04_update;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class UpdateExample01 {

	public static void main(String[] args) {
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			int bno = 12;
			//방법 1 ----------------------------------------
			//BoardDao boardDao = session.getMapper(BoardDao.class);
			//Board board = boardDao.selectBoard(bno);
			//board.setBtitle("비가 안 오네");
			//board.setBcontent("공부하기 너무 싫어요");
			//int rows = boardDao.updateBoard(board);
			
			//방법 2 ---------------------------------------
			Board board= session.selectOne("dao.BoardDao.selectBoard",bno);
			board.setBtitle("비가 안 오네");
			board.setBcontent("공부하기 너무 싫어요");
			int rows = session.update("dao.BoardDao.updateBoard",board);
			//리턴값 출력
			System.out.println("수정된 행 수 : " + rows);
			System.out.println("수정된 게시물 번호 : " + board.getBno());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	}
