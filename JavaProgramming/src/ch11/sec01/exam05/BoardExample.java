package ch11.sec01.exam05;

public class BoardExample {

	public static void main(String[] args) {
		Board b1 = new Board(1,"","","",2);
		System.out.println(b1);
		
		Board b2 = new Board(1,"","","",2);
		
		System.out.println(b1.hashCode() == b2.hashCode());
		System.out.println(b1.equals(b2));
		System.out.println(b1.toString());

	}

}
