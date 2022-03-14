package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectionManager {
	public static BasicDataSource basicDataSource;
	
	public static void init() {
		if(basicDataSource == null) {
			basicDataSource = new BasicDataSource();
			basicDataSource.setInitialSize(5);
			basicDataSource.setMaxTotal(10);
			basicDataSource.setMinIdle(5);
			basicDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			basicDataSource.setUrl("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl");
			basicDataSource.setUsername("hr");
			basicDataSource.setPassword("kosa12345");
		}
		
	}
	
	public static Connection getConnection01() throws ClassNotFoundException, SQLException {
		/*Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
		System.out.println("연결 성공");
		
		return con;*/
		
		Connection conn = basicDataSource.getConnection();

		
		return conn; 
	
	}
	public static Connection getConnection02() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@kosa1.iptime.org:50102/orcl","hr","kosa12345");
//		System.out.println("연결 성공");
		
		return con;

	
	}
}
