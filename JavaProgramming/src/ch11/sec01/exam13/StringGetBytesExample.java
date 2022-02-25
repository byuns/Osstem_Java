package ch11.sec01.exam13;

import java.io.*;

public class StringGetBytesExample {

	public static void main(String[] args) {
		try {
			String str = "안녕하세요";
			//인코딩
			byte[] bytes1 = str.getBytes("UTF-8");
			System.out.println(bytes1.length);
			
			//디코딩
			String str2 = new String(bytes1,0,6,"UTF-8");
			System.out.println(str2);
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
