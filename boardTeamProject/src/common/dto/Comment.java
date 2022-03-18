package common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
	private int cno;
	private String ccontent;
	private Date cdate;
	private String cwriter;
	private int bno;
}
