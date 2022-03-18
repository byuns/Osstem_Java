package exam04_update;

import java.util.List;

import common.dto.Board;
import exam02_select.Pager;

public class BoardService {
	private BoardDao boardDao= new BoardDao();
	
	public Board getBoard(int bno) {
		return boardDao.selectByBno(bno);
	}
	
	public int modifyBoard(Board board) {
		int rows = boardDao.update(board);
		return rows;
	}
	public List<Board> getList(Pager pager){
		return boardDao.selectAll(pager);
	}

	public int getTotalBoardNum() {
		return boardDao.count();
	}

	public int removeBoard(int bno) {
		return boardDao.deleteBoard(bno);
	}

}
