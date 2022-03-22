package config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {
	public static SqlSessionFactory sqlSessionFactory;
	
	//정적 블록 : 클래스가 메소드 영역으로 로딩되면 자동으로 실행
	static {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		try {
			String resource = "config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//자바 객체와 SQL을 매핑해서 DB 작업을 할 수 있도록 해주는 SqlSession 객체 리턴
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
