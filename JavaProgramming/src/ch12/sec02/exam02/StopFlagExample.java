package ch12.sec02.exam02;

public class StopFlagExample {

	public static void main(String[] args) {
		PrintThread1 thread = new PrintThread1();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.setStop(true);
		
		
	
	}

}
