package exam02_select;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.UserDao;
import dto.Board;
import dto.User;

public class SelectExample06 {
	public static void main(String[] args) {
		
		
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			UserDao userDao = session.getMapper(UserDao.class);
			
			//방법 1 ----------------------------------------
			//BoardDao의 메소드 호출
			//User user = userDao.selectUserWithBoards("winter");
			
			//방법 2 ----------------------------------------
			User user = session.selectOne("dao.UserDao.selectUserWithBoards","winter");
			
			//리턴값 출력
			System.out.println(user);
			for(Board board : user.getBoards()) {
				System.out.println(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
