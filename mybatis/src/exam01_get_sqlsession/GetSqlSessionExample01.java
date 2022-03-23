package exam01_get_sqlsession;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;

public class GetSqlSessionExample01 {

	public static void main(String[] args) {
		
		/*SqlSession sqlSession = null;
		try{
			sqlSession = SqlSessionManager.getSqlSession();
			System.out.println("SqlSession 객체 생성 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}*/
		
		//자동 리소스 닫기
		try(SqlSession sqlSession = SqlSessionManager.getSqlSession() ){
			System.out.println("SqlSession 객체 생성 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
