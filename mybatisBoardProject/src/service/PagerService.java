package service;

import java.util.List;
import java.util.Scanner;

import dao.BoardDao;
import dto.Board;
import dto.Pager;

public class PagerService {
	Scanner scanner = new Scanner(System.in);
	
	public void printPage(Pager pager, BoardDao boardDao,boolean flag) {
		List<Board> list;
		if(flag != true) {
			list = boardDao.selectPage(pager);
		}
		else {
			list = boardDao.selectByBcount(pager);
		}
		System.out.printf("%-5s%-30s%-20s%-10s%-5s\n", "번호", "제목", "글쓴이", "작성일자", "조회수");
		for(Board b : list) {
			System.out.printf("%-5d%-30s%-20s%-15s %-5d\n", b.getBno(), b.getBtitle(), b.getBwriter(), b.getBdate(), b.getBcount());
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
	
	public Pager movePage(Pager pager,BoardDao boardDao) { // 게시글 페이지 이동

		System.out.print("선택 : ");
		String select = scanner.nextLine();

		if(select.equals("f") || select.equals("F")) {
			pager = getFirstPage(pager,boardDao);
		} else if(select.equals("p") || select.equals("P")){
			if(pager.getPageNo() >5 )
				pager = getPrevGroup(pager,boardDao);
		} else if(select.equals("n") || select.equals("N")){
			if(pager.getPageNo() < pager.getEndPageNo())
				pager = getNextGroup(pager,boardDao);
		} else if(select.equals("l") || select.equals("L")){
			pager = getLast(pager,boardDao);
		} else {
			if(Integer.parseInt(select) > pager.getEndPageNo() || Integer.parseInt(select) < 1) {
				System.out.println("존재하지 않는 페이지 입니다.");
			}else
				pager = getPage(Integer.parseInt(select),pager,boardDao);
		}
		return pager;
	}

	private Pager getFirstPage(Pager pager, BoardDao boardDao) {
		pager = new Pager(10, 5, boardDao.selectTotalRowCount(), 1);
		return pager;
	}
	
	private Pager getPrevGroup(Pager pager,BoardDao boardDao ) {
		pager = new Pager(10, 5, boardDao.selectTotalRowCount(), pager.getStartPageNo() - 1);
		return pager;
	}
	
	private Pager getPage(int pageNo,Pager pager, BoardDao boardDao) {
		pager = new Pager(10, 5, boardDao.selectTotalRowCount(), pageNo);
		return pager;
	}

	private Pager getNextGroup(Pager pager, BoardDao boardDao) {
		pager = new Pager(10, 5, boardDao.selectTotalRowCount(), pager.getEndPageNo() + 1);
		return pager;
	}

	private Pager getLast(Pager pager, BoardDao boardDao) {
		pager = new Pager(10, 5, boardDao.selectTotalRowCount(), pager.getTotalPageNo());
		return pager;
	}
	

}
