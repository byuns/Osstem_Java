package ch12.sec01.exam03;

public class ThreadNameExample {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		
		System.out.println(thread.getName() + "가 출력한 내용_0");
		
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadB.setName("ThreadB");
		
		threadA.start();
		threadB.start();
	}

}

