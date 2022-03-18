package exam05_delete;

import java.util.List;
import java.util.Scanner;

import common.dto.Board;
import exam01_connect.ConnectionManager;
import exam02_select.Pager;
import exam04_update.BoardService;

public class DeleteExample01 {
	public static void main(String[] args) {
		ConnectionManager.init();
		
		BoardService boardService = new BoardService();

		//게시물 수정 확인하기
		
		Pager pager = new Pager(10,5,boardService.getTotalBoardNum(),1);
		List<Board> list = boardService.getList(pager);
		for(Board b : list) {
			System.out.println(b);
		}
		
		System.out.println("----------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 번호 : ");
		int bno = Integer.parseInt(sc.nextLine());
		boardService.removeBoard(bno);
		
		System.out.println("----------------------------------------------------");
		pager = new Pager(10,5,boardService.getTotalBoardNum(),1);
		list = boardService.getList(pager);
		for(Board b : list) {
			System.out.println(b);
		}
	}
}
