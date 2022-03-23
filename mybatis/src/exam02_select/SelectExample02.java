package exam02_select;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dto.Board;

public class SelectExample02 {
	public static void main(String[] args) {
		
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){		
			//방법 1 ----------------------------------------

			//BoardDao 구현 객체 얻기
			BoardDao boardDao = session.getMapper(BoardDao.class);
			//BoardDao의 메소드 호출
			//List<Board> list = boardDao.selectAll();
		
					
			//방법 2 ----------------------------------------
			List<Board> list = session.selectList("dao.BoardDao.selectAll");
			
			//리턴값 출력
			for(Board board : list) {
				System.out.println(board);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
