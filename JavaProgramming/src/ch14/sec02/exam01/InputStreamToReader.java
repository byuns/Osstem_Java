package ch14.sec02.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamToReader {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test1.txt");
			
			Reader reader = new InputStreamReader(is,"UTF-8");
			
			char[] buffer = new char[100];
			int num = reader.read(buffer);
			String str = new String(buffer,0,num);
			System.out.println(str);
			
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
