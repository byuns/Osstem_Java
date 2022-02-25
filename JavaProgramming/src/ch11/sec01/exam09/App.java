package ch11.sec01.exam09;

public class App {
	public static void main(String[] args) {
		Class clazz = App.class;
		
		String image1Path = clazz.getResource("image1.png").getPath();
		System.out.println(image1Path);
		
		String image2Path = clazz.getResource("images/image2.png").getPath();
		System.out.println(image2Path);
		
	}

}
