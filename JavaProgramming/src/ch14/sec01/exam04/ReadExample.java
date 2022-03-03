package ch14.sec01.exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test1.db");
			while(true) {
				int data = is.read();
				if(data == -1) 
					break;
				System.out.println((byte)data);
			}
			
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
