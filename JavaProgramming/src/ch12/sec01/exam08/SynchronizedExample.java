package ch12.sec01.exam08;

import java.util.ArrayList;
import java.util.Vector;


public class SynchronizedExample {

	public static void main(String[] args) {
		
		Vector list = new Vector();
		
		//공유 객체 생성
		User1 user1 = new User1();
		user1.setList(list);
		user1.start();
				
		User2 user2 = new User2();
		user2.setList(list);
		user2.start();		
		
		
		//메인 스레드 대기
		try {
			user1.join();
			user2.join();
		} catch (InterruptedException e) {
		}
		System.out.println("총 저장된 수 : " + list.size());
	}

}
