package ch14.sec01.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("C:/Temp/imgae1.png");
			OutputStream os = new FileOutputStream("C:/Temp/image2.png");
			
			byte[] buffer = new byte[1000];
			byte[] copy = new byte[1000];
			
			while(true) {
				int readByteNum = is.read(buffer);
				if(readByteNum == -1)
					break;
				for(int i=0; i<readByteNum; i++) {
					copy[i] = buffer[i];
				}
				os.write(copy);
				
			}
			os.flush();	
			is.close();
			os.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}

}
