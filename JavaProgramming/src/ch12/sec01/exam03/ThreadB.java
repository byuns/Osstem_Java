package ch12.sec01.exam03;

public class ThreadB extends Thread {
	@Override
	public void run() {
		for(int i=0; i<10000; i++) {
//			Thread thread = Thread.currentThread();
			System.out.println(getName() + "가 출력한 내용_2");
		}
	}

}
