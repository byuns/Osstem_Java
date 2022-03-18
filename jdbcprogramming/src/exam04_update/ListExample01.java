package exam04_update;

import java.sql.Connection;
import java.util.List;

import common.dto.Board;
import exam01_connect.ConnectionManager;
import exam02_select.Pager;


public class ListExample01 {

	public static void main(String[] args) {
		Connection conn = null;
		ConnectionManager.init();
		
		BoardService boardService = new BoardService();

		//게시물 수정 확인하기
		
		Pager pager = new Pager(10,5,boardService.getTotalBoardNum(),1);
		List<Board> list = boardService.getList(pager);
		for(Board b : list) {
			System.out.println(b);
		}
	}

}
