package boardProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionManager {
	public static BasicDataSource basicDataSource;
	
	public static void init() {
		// Connection Pool 만들기
		if(basicDataSource == null) {
			basicDataSource = new BasicDataSource();
			basicDataSource.setInitialSize(5);	// 초기 커넥션 수
			basicDataSource.setMaxTotal(10);	// 최대 커넥션 수
			basicDataSource.setMinIdle(5);		// 더이상 안 쓸 경우 몇개까지 남기고 제거할 것인지
			basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");	// 사용할 드라이버
			basicDataSource.setUrl("jdbc:oracle:thin:@kosa1.iptime.org:50103/orcl");	// 연결 문자열
			basicDataSource.setUsername("team3");
			basicDataSource.setPassword("kosa12345");
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 대여하기
		Connection conn = basicDataSource.getConnection();	// 커넥션 풀이 갖고 있는 커넥션 대여
		return conn;
	}
}
