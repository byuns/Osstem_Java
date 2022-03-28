package service;

import java.io.File;
import java.util.Scanner;

import dao.BoardDao;
import dto.Board;

public class PrintService {
	Scanner scanner = new Scanner(System.in);
	CommentService commentService = new CommentService();
	public void printWrite(Board board, String user,BoardDao boardDao) {
		while (true) {
			System.out.print("제목 : ");
			String btitle = scanner.nextLine();
			if (btitle.replace(" ", "").equals("")) {
				System.out.println("제목을 입력해주세요.");
				continue;
			}
			System.out.print("내용 : ");
			String bcontent = scanner.nextLine();
			if (bcontent.replace(" ", "").equals("")) {
				System.out.println("내용을 입력해주세요.");
				continue;
			}
			board.setBtitle(btitle);
			board.setBcontent(bcontent);
			
			System.out.print("파일 경로 : ");
			String bfilepath = scanner.nextLine();

			System.out.print("게시글 비밀번호 : ");
			String bpassword = scanner.nextLine();
			
			if (!bfilepath.replace(" ", "").equals("")) {
				File file = new File(bfilepath);
				if (file.exists()) {
					board.setBfilepath(bfilepath);
				} else {
					System.out.println("파일이 존재하지 않습니다.");
					continue;
				}
			}
			if (!bpassword.replace(" ", "").equals("")) {
				board.setBpassword(bpassword);
			}
			board.setBwriter(user);
			
			boardDao.insertBoard(board);
			break;
		}
	}
	
	public void printView(Board board, String userid, BoardDao boardDao) {
		System.out.print("볼 게시글 번호 : ");
		int num = Integer.parseInt(scanner.nextLine());
		board = boardDao.selectBoard(num);
		boolean flag = false;
		if (board.getBpassword() != null) {
			System.out.println("비밀번호가 설정되어 있습니다");
			while (true) {
				System.out.print("비밀번호(뒤로 가려면 공백) : ");
				String bpassword = scanner.nextLine();
				if (board.getBpassword().equals(bpassword)) {
					break;
				} else if (bpassword.replace(" ", "").equals("")) {
					flag = true;
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
		}
		if (flag != true) {
			System.out
					.println("번호 : " + board.getBno() + " 제목 : " + board.getBtitle() + " 작성자 : " + board.getBwriter());
			System.out.println("작성일자 : " + board.getBdate() + " 조회수 : " + board.getBcount());
			System.out.println("내용 :" + board.getBcontent());
			System.out.println("첨부파일 :" + board.getBfilename());
			
			System.out.println("1. 댓글보기 | 2. 목록으로");
			String cmd = scanner.nextLine();
			if (cmd.equals("1")) {
				commentService.getBoardComment(board.getBno(), userid);
			} else if (cmd.equals("2")) {
				System.out.println("목록으로 돌아갑니다.");
			} else {
				System.out.println("잘못된 입력으로 목록으로 돌아갑니다.");
			}
			boardDao.count(num);
		}
	}
	
	public void printModify(Board board, String user,BoardDao boardDao) {
		System.out.print("수정할 게시글 번호 : ");
		int num = Integer.parseInt(scanner.nextLine());
		board = boardDao.selectBoard(num);
		if (!board.getBwriter().equals(user)) {
			System.out.println("작성자가 아니므로 해당 게시글을 수정할 수 없습니다.");
		} else {
			System.out.println("수정을 원치 않는 부분은 공백 처리해주세요.");
			System.out.print("제목 : ");
			String btitlem = scanner.nextLine();
			if (!btitlem.replace(" ", "").equals(""))
				board.setBtitle(btitlem);

			System.out.print("내용 : ");
			String bcontentm = scanner.nextLine();
			if (!bcontentm.replace(" ", "").equals(""))
				board.setBcontent(bcontentm);

			System.out.print("파일경로 : ");
			String bfilepathm = scanner.nextLine();
			if (!bfilepathm.replace(" ", "").equals(""))
				board.setBfilepath(bfilepathm);

			boardDao.modifyBoard(board);
			
		}
	}
	
	public void printDelete(Board board, String user, BoardDao boardDao) {
		System.out.print("삭제할 게시글 번호 : ");
		int num = Integer.parseInt(scanner.nextLine());
		board = boardDao.selectBoard(num);
		if (!board.getBwriter().equals(user)) {
			System.out.println("작성자가 아니므로 해당 게시글을 삭제할 수 없습니다.");
		} else {
			boardDao.removeBoard(num);
			System.out.println("게시글 삭제가 완료되었습니다.");
		}
	}

}
