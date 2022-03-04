package ch14.sec02.exam03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


public class AddLineNumberExample {
	public static void main(String[] args) {
		
		try {
			String file = "C:/osstem/workspace/JavaProgramming/src/ch14/sec02/exam03/ReadLineExample.java";
			Reader fr = new FileReader(file);
			BufferedReader bs = new BufferedReader(fr);
			int i=0;
			while(true) {
				String str = bs.readLine();
				i++;
				if(str == null) break;
				System.out.println(i+". " + str );
			}
			bs.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
