package ch12.sec02.exam01;

public class JoinExample {
	private static int sum;
	
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			for(int i=0;i<100;i++) {
				sum += i;
			}
		});
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("sum : " + sum);

	}

}
