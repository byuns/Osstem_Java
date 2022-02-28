package apendix.lambda.exam06;

public class MethodReferanceExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		person.action(Computer :: staticMethod);
 
	}

}
