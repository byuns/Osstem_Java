package ch14.sec01.exam09;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {
	public static void main(String[] args) {
		try {
			Writer writer = new FileWriter("C:/Temp/test9.txt");
			
			char[] array = {'A','B','C','D','E'};
			
			writer.write(array,1,3);
			
			writer.flush();
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
