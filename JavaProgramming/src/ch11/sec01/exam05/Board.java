package ch11.sec01.exam05;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int hitCount;
	



}
