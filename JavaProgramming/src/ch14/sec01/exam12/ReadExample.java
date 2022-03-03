package ch14.sec01.exam12;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("C:/Temp/test7.txt");
			
			char[] buffer = new char[100];
			
			while(true) {
				int data = reader.read(buffer);
				if(data == -1) break;
				for(int i=0; i<data;i++) {
					System.out.println(buffer[i]);
				}
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
