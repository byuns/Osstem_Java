package ch06.sec04.exam06;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		double result1 = myCalc.areaRectangle(10);
		
		double result2 = myCalc.areaRectangle(10,20);
		
		System.out.println(result1+", "+result2);

	}

}
