package ch02.sec03;

public class CastingExample {
	public static void main(String args[]) {
		//강제 타입 변환
		int var1 = 200;
		byte var2 = (byte)var1;
		
		System.out.println(var2);
		
		short var3 = (short)var1;
		
		System.out.println(var3);
		
		//정수 -> 실수
		float var4 = var1;
		
		System.out.println(var4);
		
		long var5 = 1000000000000000000l;
		float var6 = var5;
		double var7 = var5;
		System.out.println(var6);
		System.out.println(var7);
		
		//실수 -> 정수
		double var8 = 3.5;
		int var9 = (int)var8;
		float var10 = 3.5f;
		int var11 = (int)var10;
		
		//정수 -> 문자
		int var12 = 65;
		char var13 = (char)var12;
		
	}

}
