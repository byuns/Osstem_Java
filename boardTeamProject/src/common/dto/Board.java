package common.dto;

import java.sql.Blob;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	// bfilename, bfiledata는 저장할 때는 쓰지 않고, 읽을 때 사용
	private String bfilename;
	private Blob bfiledata;
	private String bfilepath;
	
	private String bpassword;
	private int bcount;
}
