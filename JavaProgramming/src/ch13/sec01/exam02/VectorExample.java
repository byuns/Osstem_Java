package ch13.sec01.exam02;
import java.util.*;
public class VectorExample {

	public static void main(String[] args) {
		List<Board> list = new Vector<>();
		
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				for(int i=1; i<=1000000;i++) {
					list.add(new Board("제목"+i, "내용"+i,"글쓴이"+i));
				}
			}
		};
		
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				for(int i=1000001; i<=2000000;i++) {
					list.add(new Board("제목"+i, "내용"+i,"글쓴이"+i));
				}
			}
		};
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}catch(Exception e) {
			
		}
		
		System.out.println("총 개시물 수 : "+list.size());

	}

}
