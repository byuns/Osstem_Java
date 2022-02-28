package ch12.sec01.exam07;

public class User2 extends Thread {
	
	private Calculator calculator;

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	public void run() {
		calculator.setMemory(50);
	}
	


}
