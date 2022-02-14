package ch02.sec03;

public class PromotionExample {

	public static void main(String[] args) {
		//자동 타입 변환
		byte var1 = 10;
		short var2 = var1;
		int var3 = var2;
		long var4 = var3;
		float var5 = var4;
		double var6 = var5;
		
		
		char var7 = (char)var1;
		
		byte var8 = 1;
		byte var9 = 1;
		int var10 = var8 + var9; // int로 바꾸어 연산한다.
		
		
	}

}
