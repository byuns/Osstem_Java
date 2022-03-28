package dto;

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
	private String bfilename;
	private byte[] bfiledata;
	private String bfilepath;
	
	private String bpassword;
	private int bcount;
}
