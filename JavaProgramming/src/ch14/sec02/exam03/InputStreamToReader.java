package ch14.sec02.exam03;

import java.io.BufferedReader;
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
			BufferedReader br  = new BufferedReader(reader);
			
			String str = br.readLine();
			System.out.println(str);
			
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
