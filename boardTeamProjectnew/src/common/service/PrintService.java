package common.service;

import java.util.Scanner;

import common.dto.Board;

public class PrintService {
	Scanner scanner = new Scanner(System.in);
	
	public void printWrite(Board board, BoardService boardService) {
		System.out.print("제목 : ");
		String btitle = scanner.nextLine();
		System.out.print("내용 : ");
		String bcontent = scanner.nextLine();
		System.out.print("파일 경로 : ");
		String bfilepath = scanner.nextLine();
		System.out.print("게시글 비밀번호 : ");
		String bpassword = scanner.nextLine();
		
		board.setBtitle(btitle);
		board.setBcontent(bcontent);
		if(!bfilepath.replace(" ", "").equals("")) {
			board.setBfilepath(bfilepath);
		}
		if(!bpassword.replace(" ", "").equals("")) {
			board.setBpassword(bpassword);
		}
		boardService.insertBoard(board);
		System.out.println("게시글이 작성이 완료되었습니다.");
	}
}
