package ch14.sec01.exam01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args)  {
		OutputStream os = null;
		try {
			os = new FileOutputStream("C:/Temp/test1.db");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		try {
			os.write(a);
			os.write(b);
			os.write(c);
		
			os.flush();
			os.close();
		}catch(IOException e){
			
		}
	}

}
