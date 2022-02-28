package ch12.sec01.exam01;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	public static void main(String[] args) {
		//효과음을 내는 작업
		Thread thread = new Thread(new Task());
		thread.start();
		
		//콘솔에 출력하는 작업
		for(int i = 0; i< 5; i++) {
			System.out.println("띵");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
			
		}
		
	}

}
