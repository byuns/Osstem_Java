package common.service;

import java.util.List;

import boardProject.Pager;
import common.dao.BoardDao;
import common.dto.Board;

public class BoardService {
	// 비즈니스 로직, 기능 중심의 메소드로 구성
	// Field
	private BoardDao boardDao = new BoardDao();
	
	// Method
	// 해당 번호 보드 정보 가져오기
	public Board getBoard(int bno,Board board) {
		return boardDao.selectByBno(bno,board);
	}	// 로그인 작업에서는 리턴 받은 user 객체와 입력값 비교
	
	// 게시물 수정
	public int modifyBoard(Board board) {	// 보통 select를 제외하고는 int를 리턴
		int rows = boardDao.update(board);
		return rows;
	}
	
	// 전체 보드 리스트 가져오기
	public List<Board> getList(Pager pager) {
		return boardDao.selectAll(pager);
	}

	// 전체 게시물 수
	public int getTotalBoardNum() {
		return boardDao.count();
	}

	// 해당 번호 게시물 지우기
	public int removeBoard(int bno) {
		return boardDao.deleteByBno(bno);
	}
	
	// 게시글 쓰기
	public int insertBoard(Board board) {
		return boardDao.insert(board);
	}
	
	// 조회수 순으로 정렬 sortView()
}
