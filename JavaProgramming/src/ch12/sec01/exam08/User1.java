package ch12.sec01.exam08;

import java.util.ArrayList;
import java.util.Vector;

public class User1 extends Thread {
	
	private Vector list;


	public void setList(Vector list) {
		this.setName("User1");
		this.list = list;
	}
	@Override
	public void run() {
		for(int i=0; i<10000000; i++) {
			list.add(i);
		}
		
	}
}
