package apendix.generic.exam04;

public class GenericExample {

	public static void main(String[] args) {
		
		Box<Product<String,String>>  box1 = new Box<>();
		Product<String, String> p1 = new Product<>();
		p1.setKind("TV");
		p1.setModel("Smart TV");
		
		box1.content = p1;
		
		Box<Product<String,String>>  box2 = new Box<>();
		Product<String, String> p2 = new Product<>();
		p2.setKind("TV");
		p2.setModel("Smart TV");
		
		box2.content = p2;
		
		boolean result = box1.compare(box2);
		System.out.println(result);
		

	}

}
