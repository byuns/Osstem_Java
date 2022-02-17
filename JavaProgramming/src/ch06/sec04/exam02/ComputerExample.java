package ch06.sec04.exam02;

public class ComputerExample {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		
		int[] values1 = {1,2,3};
		int result = myCom.sum(values1);
		System.out.println(result);
		
		int result2 = myCom.sum2(new int[] {1,2,3,4,5});
		System.out.println(result2);
		

	}

}
