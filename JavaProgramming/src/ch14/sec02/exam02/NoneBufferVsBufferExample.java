package ch14.sec02.exam02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NoneBufferVsBufferExample {

	public static void main(String[] args) {
		try {
			
			String originalFilePath = NoneBufferVsBufferExample.class.getResource("image1.png").getPath();
			String targetFilePath = "C:/Temp/image2.png";
			
			//기본 스트림만 생성
			FileInputStream fis1 = new FileInputStream(originalFilePath);
			FileOutputStream fos1 = new FileOutputStream(targetFilePath);
			
			//버퍼를 제공하는 보조 스트림
			FileInputStream fis2 = new FileInputStream(originalFilePath);
			FileOutputStream fos2 = new FileOutputStream(targetFilePath);
			BufferedInputStream bis = new BufferedInputStream(fis2);
			BufferedOutputStream bos = new BufferedOutputStream(fos2);
			
			long noneBufferTime = copy(fis1,fos1);
			System.out.println("버퍼를 사용하지 않았을 때: \t" + noneBufferTime + "ns");
			
			long bufferTime = copy(bis,bos);
			System.out.println("버퍼를 사용했을 때: \t" + bufferTime + "ns");
			
			fis1.close();
			fos1.close();
			bis.close();
			bos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
		public static long copy(InputStream is, OutputStream os) throws IOException{ // 호출하는 쪽에 예외를 떠넘김
			
			long start = System.nanoTime();
			while(true) {
				int data = is.read();
				if(data == -1) break;
				os.write(data);
			}
			os.flush();
			long end = System.nanoTime();
			return (end-start);
			
		}
	}


