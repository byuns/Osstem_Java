package ch14.sec02.exam05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class PrintStreamExample {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/printStream.txt");
			PrintStream ps = new PrintStream(fos);
			
			ps.println("[프린터 보조 스트림]");
			ps.print("마치 ");
			ps.println("프린터가 출력하는 것처럼");
			ps.println("데이터를 출력합니다.");
			
			ps.flush();
			ps.close();
			
			FileInputStream fis = new FileInputStream("C:/Temp/printStream.txt");
			Reader r = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(r);
			
			while(true) {
				String read = br.readLine();
				if(read == null) break;
				System.out.println(read);
			}
			br.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
