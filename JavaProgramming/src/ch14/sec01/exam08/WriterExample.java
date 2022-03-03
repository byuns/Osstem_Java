package ch14.sec01.exam08;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:/Temp/test8.txt");
			
			char[] array = {'A','B','C'};
			
			writer.write(array);
			
			writer.flush();
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
