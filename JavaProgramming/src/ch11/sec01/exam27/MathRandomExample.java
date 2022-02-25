package ch11.sec01.exam27;
import java.util.Random;

public class MathRandomExample {

	public static void main(String[] args) {
		Random rand = new Random();
		Random rand2 = new Random();
		
		int tmp1 = rand.nextInt(10)+1;
		System.out.println(tmp1);
		int tmp3 = rand2.nextInt(10)+1;
		System.out.println(tmp3);
		
		double tmp2 = rand.nextDouble();
		System.out.println(tmp2);
		
		System.out.println("---------");
		int[] test = new int[10];
		for(int i=0; i<10000; i++) {
			int tmp = rand.nextInt(10) + 1;
			test[tmp-1]++;
		}
		for(int i=0; i<test.length; i++) {
			System.out.println(test[i]);
		}
	}

}
