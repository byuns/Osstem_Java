package ch02.sec02;

public class EscapeExample {
	public static void main(String args[]) {
		String message = "나는 \"자바\"를 좋아합니다.";
		
		System.out.println(message);
		
//		String message2 = """
//				나는 "자바"를 좋아합니다.
//				""";
//		System.out.println(message2);
		//properties >> JAVA Build Path >> Add Library >> Java Compiler >> 17_version
		
		message = "나는 \\자바\\를 좋아합니다.";
		System.out.println(message);
		
		message = "나는 \t자바\t를 좋아합니다.";
		System.out.println(message);
		
		message = "나는 자바를 좋아합니다.\n나는 연봉 3억의 개발자가 될겁니다.";
		System.out.println(message);
	}

}
