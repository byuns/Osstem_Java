package ch12.sec02.exam02;

public class PrintThread1 extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("실행중");
		}
	}
	
}
