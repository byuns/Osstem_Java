package ch14.sec01.exam05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test2.db");
			
			byte[] buffer = new byte[100];
			
			while(true) {
				int readByteNum = is.read(buffer);
				if(readByteNum == -1)
					break;
				for(int i=0; i<readByteNum; i++)
					System.out.println(buffer[i]);
			}
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}