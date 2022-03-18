package exam04_update;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import common.dto.Board;
import exam01_connect.ConnectionManager;
import exam02_select.Pager;


public class UpdateExample01 {

	public static void main(String[] args) {
		Connection conn = null;
		ConnectionManager.init();
		
		BoardService boardService = new BoardService();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("게시물 번호 : ");
		int bno = Integer.parseInt(sc.nextLine());
		
		Board board = boardService.getBoard(bno);
		System.out.println("btitle : " + board.getBtitle());
		System.out.println("bcontent : " + board.getBcontent());
		System.out.println("bfilename : " + board.getBfilename());
		
		System.out.print("btitle : ");
		String btitle = sc.nextLine();
		if(!btitle.equals("")) board.setBtitle(btitle);
		
		System.out.print("bcontent : ");
		String bcontent = sc.nextLine();
		if(!bcontent.equals("")) board.setBcontent(bcontent);
		
		System.out.print("bfilepath : ");
		String bfilepath = sc.nextLine();
		if(!bfilepath.equals("")) board.setBfilepath(bfilepath);
		
		boardService.modifyBoard(board);
		
		//게시물 수정 확인하기
		System.out.println();
		board = boardService.getBoard(bno);
		System.out.println("bno : " + board.getBno());
		System.out.println("btitle : " + board.getBtitle());
		System.out.println("bcontent : " + board.getBcontent());
		System.out.println("bwriter : " + board.getBwriter());
		System.out.println("bdate : " + board.getBdate());
		System.out.println("bfilename : " + board.getBfilename());
		
		
		Pager pager = new Pager(10,5,boardService.getTotalBoardNum(),1);
		List<Board> list = boardService.getList(pager);
		for(Board b : list) {
			System.out.println(b);
		}
	}

}
