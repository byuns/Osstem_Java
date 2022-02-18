package ch07.sec01.exam03;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		Calculator cal = new Calculator();
		System.out.println("원면적 : " +cal.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원면적 : " + computer.areaCircle(r));
		
	

	}

}
