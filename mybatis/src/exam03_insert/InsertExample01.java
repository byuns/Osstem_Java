package exam03_insert;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dao.UserDao;
import dto.Board;
import dto.User;

public class InsertExample01 {

	public static void main(String[] args) {
		try(SqlSession session = SqlSessionManager.getSqlSession()){	
			
			User user = new User();
			user.setUserId("user4");
			user.setUserName("사용자4");
			user.setUserPassword("12345");
			user.setUserAge(25);
			user.setUserEmail("user4@mycompany.com");
			//방법 1 ----------------------------------------
			//UserDao userDao = session.getMapper(UserDao.class);
			//int rows = userDao.insertUser(user);
					
			//방법 2 ---------------------------------------
			int rows = session.insert("dao.UserDao.insertUser",user);
			
			//리턴값 출력
			System.out.println("저장된 행 수 : " + rows);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
