package ch14.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamToWriter {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test1.txt");
			Writer writer = new OutputStreamWriter(os,"UTF-8");
			
			String data = "봄이 왔어요.";
			
			
			writer.write(data);
			
			writer.flush();
			writer.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
