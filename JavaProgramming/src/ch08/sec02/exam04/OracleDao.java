package ch08.sec02.exam04;

public class OracleDao implements DataAccessObject{
	@Override
	public void select() {
		System.out.println("Oracle DB에서 검색");
	}
	@Override
	public void insert() {
		System.out.println("Oracle DB에 삽입");
	}
	@Override
	public void upadate() {
		System.out.println("Oracle DB를 수정");
	}
	@Override
	public void delete() {
		System.out.println("Oracle DB를 삭제");
	}
	
	

}
