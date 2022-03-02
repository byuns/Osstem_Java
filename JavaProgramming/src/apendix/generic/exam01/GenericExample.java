package apendix.generic.exam01;

public class GenericExample {

	public static void main(String[] args) {
		Box<String> box = new Box();
		box.content = "hello";
		String content = box.content;
		System.out.println(content);
		
		Box<Integer> box2 = new Box();
		box2.content = 1;
		int content2 = box2.content;
		System.out.println(content2);
		
		Box<Clock> box3 = new Box();
		box3.content = new Clock();
		Clock content3 = box3.content;
		
	}

}
