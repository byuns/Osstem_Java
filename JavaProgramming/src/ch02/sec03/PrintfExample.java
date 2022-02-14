package ch02.sec03;

public class PrintfExample {

	public static void main(String[] args) {
		int value = 123;
		System.out.printf("상품의 가격 : %d원\n",value);
		System.out.printf("상품의 가격 : %6d원\n",value);
		System.out.printf("상품의 가격 : %-6d원\n", value);
		System.out.printf("상품의 가격 : %06d원\n",value);
		double value2 = 123456789.116414;
		System.out.printf("%10.2f",value2);
		

	}

}
