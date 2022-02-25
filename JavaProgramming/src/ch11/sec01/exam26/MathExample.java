package ch11.sec01.exam26;

public class MathExample {

	public static void main(String[] args) {
		double v3 = Math.ceil(5.3);
		double v4 = Math.ceil(-5.3);
		System.out.println(v3);
		System.out.println(v4);
		
		double v5 = Math.floor(5.3);
		double v6 = Math.floor(-5.3);
		System.out.println(v4);
		System.out.println(v6);
		
		int v11 = (int)(Math.random()*10)+1;
		System.out.println(v11);
		
		long v14 = Math.round(5.3);
		long v15 = Math.round(-5.3);
		System.out.println(v14);
		System.out.println(v15);
		
		double value = 12.3456;
		double tmp1 = value * 100;
		long tmp2 = Math.round(tmp1);
		double v16 = tmp2/100.0;
		System.out.println(v16);
	}
}
