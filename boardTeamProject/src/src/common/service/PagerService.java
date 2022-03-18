package common.service;

import java.util.List;
import java.util.Scanner;

import boardProject.Pager;
import common.dto.Board;

public class PagerService {
	BoardService boardService = new BoardService();
	Scanner scanner = new Scanner(System.in);
	
	public void printPage(Pager pager,boolean flag) {// 페이지 마다 게시글 출력
		List<Board> list = boardService.getList(pager,flag);
		System.out.printf("%-5s%-30s%-20s%-10s%-5s\n", "번호", "제목", "글쓴이", "작성일자", "조회수");
		for(Board b : list) {
			System.out.printf("%-5d%-30s%-20s%-15s%-5d\n", b.getBno(), b.getBtitle(), b.getBwriter(), b.getBdate(), b.getBcount());
		}
		System.out.println("--------------------------------------------------------------");
		System.out.print("[First]");
		System.out.print((pager.getGroupNo()) >= 2 ? "[Prev] " : "");
		for(int i = pager.getStartPageNo(); i <= pager.getEndPageNo(); i++) {
			if(i == pager.getPageNo()) {
				System.out.print("("+ i + ")" + ((i != pager.getEndPageNo())?", ":""));
			} else {
				System.out.print(i+ ((i != pager.getEndPageNo())?", ":""));
			}
		}
		System.out.print((pager.getGroupNo()) < pager.getTotalGroupNo() ? " [Next] " : "");
		System.out.println("[Last]");
		
	}
	
	public Pager movePage(Pager pager) { // 게시글 페이지 이동

		System.out.print("선택 : ");
		String select = scanner.nextLine();

		if(select.equals("f") || select.equals("F")) {
			pager = getFirstPage(pager);
		} else if(select.equals("p") || select.equals("P")){
			pager = getPrevGroup(pager);
		} else if(select.equals("n") || select.equals("N")){
			pager = getNextGroup(pager);
		} else if(select.equals("l") || select.equals("L")){
			pager = getLast(pager);
		} else {
			pager = getPage(Integer.parseInt(select),pager);
		}
		return pager;
	}
	
	
	private Pager getFirstPage(Pager pager) {
		pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
		return pager;
	}
	
	private Pager getPrevGroup(Pager pager) {
		pager = new Pager(10, 5, boardService.getTotalBoardNum(), pager.getStartPageNo() - 1);
		return pager;
	}
	
	private Pager getPage(int pageNo,Pager pager) {
		pager = new Pager(10, 5, boardService.getTotalBoardNum(), pageNo);
		return pager;
	}

	private Pager getNextGroup(Pager pager) {
		pager = new Pager(10, 5, boardService.getTotalBoardNum(), pager.getEndPageNo() + 1);
		return pager;
	}

	private Pager getLast(Pager pager) {
		pager = new Pager(10, 5, boardService.getTotalBoardNum(), pager.getTotalPageNo());
		return pager;
	}
}
