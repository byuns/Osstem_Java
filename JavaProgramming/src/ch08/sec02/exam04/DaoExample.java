package ch08.sec02.exam04;

public class DaoExample {
	public static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.upadate();
		dao.delete();
		
	}
	

	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
		

	}

}
