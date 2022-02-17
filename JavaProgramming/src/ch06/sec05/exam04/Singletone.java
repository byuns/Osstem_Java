package ch06.sec05.exam04;

public class Singletone {
	//Field
	private static Singletone xxx = new Singletone();
	
	//Constructor
	private Singletone(){
		
	}
	
	//Method
	public static Singletone getInstance() {
		return xxx;
	}

}
