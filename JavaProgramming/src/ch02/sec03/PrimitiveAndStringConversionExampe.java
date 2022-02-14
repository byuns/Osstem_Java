package ch02.sec03;

public class PrimitiveAndStringConversionExampe {
	public static void main(String args[]) {
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("10");
		
		int value3 = 5;
		String value4 = "" + value3;
		String value5 = String.valueOf(value3);
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value4);
		System.out.println(value5);
		
		

		
	}

}
