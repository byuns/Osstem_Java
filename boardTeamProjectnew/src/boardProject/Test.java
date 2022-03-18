package boardProject;

import java.util.List;
import java.util.Scanner;

import common.dto.Board;
import common.service.BoardService;
/*
 	1. 게시물 작성		 - 변승진
	6. 로그인			  - 박경림
	7. 회원가입 		 - 김예원
	5. 조회수 순으로 정렬 - 오윤세
	
	3. 댓글 보기
	4. 댓글 삭제	
	2. 비밀글 보기
 */
public class Test {
	public static void main(String[] args) {
		ConnectionManager.init();
		
		BoardService boardService = new BoardService();
		
		Scanner sc = new Scanner(System.in);
		
		// 게시물 목록 가져오기
		System.out.println("----------------------------------------------------");
		Pager pager = new Pager(10, 5, boardService.getTotalBoardNum(), 1);
		List<Board> list = boardService.getList(pager);
		for(Board b : list) {
			System.out.println(b);
		}
	}
}
