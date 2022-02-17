package ch06.sec05.exam04;

public class SingletoneExample {

	public static void main(String[] args) {
//		Singletone s1 = new Singletone();
//		Singletone s2 = new Singletone();
		
		Singletone s1 = Singletone.getInstance();
		Singletone s2 = Singletone.getInstance();

	}

}
