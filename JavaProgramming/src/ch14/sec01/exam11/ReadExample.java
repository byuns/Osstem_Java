package ch14.sec01.exam11;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("C:/Temp/test7.txt");
			
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				System.out.println((char)data);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
