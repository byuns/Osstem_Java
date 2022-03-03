package ch14.sec01.exam10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:/Temp/test10.txt");
			
			String str = "ABC";
			writer.write(str);
			
			writer.flush();
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
