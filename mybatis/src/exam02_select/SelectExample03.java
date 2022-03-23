package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;
import dto.Pager;

public class SelectExample03 {
	public static void main(String[] args) {
		
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			Pager pager = new Pager(5,5,boardDao.selectTotalRowCount(),2);
			//방법 1 ----------------------------------------
			//BoardDao의 메소드 호출
			//List<Board> list = boardDao.selectPage(pager);
			
			//방법 2 ----------------------------------------
			List<Board> list = session.selectList("dao.BoardDao.selectPage",pager);
			
			//리턴값 출력
			for(Board board : list) {
				System.out.println(board);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
