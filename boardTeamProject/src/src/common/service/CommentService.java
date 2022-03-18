package common.service;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import boardProject.Pager;
import common.dao.CommentDao;
import common.dto.Comment;

public class CommentService {
	private CommentDao commentDao = new CommentDao();
	private List<Comment> boardComments;
	Pager pager;
	Scanner sc = new Scanner(System.in);

	// Method
	// 특정 게시물 댓글 리스트 가져오기
	public List<Comment> getList(Pager pager) {
		return commentDao.selectAll(pager);
	}

	// 특정 게시물 댓글 수
	public int getTotalCommentNum(int bno) {
		return commentDao.count(bno);
	}
	
	// 특정 게시물 댓글 리스트 페이징
	public int getBoardComment(int bno, String nowUser) {
		int result = -1;
		int totalCommentNum = getTotalCommentNum(bno);
		pager = new Pager(5, 3, totalCommentNum, 1);
		String line = "";
		for(int i=0; i<155; i++)
			line += "-";
		
		while (true) {
			System.out.println(line);
			System.out.printf("%-10s%-100s%-12s%-20s\n", "댓글번호", "내용", "작성날짜", "작성자");
			System.out.println(line);
			
			boardComments =  commentDao.selectByBno(bno, pager);
			for(int i=0; i<boardComments.size(); i++) {
				Comment c = boardComments.get(i);
				int cIdx = i+1;
				String ccontent = c.getCcontent();
				Date cdate = c.getCdate();
				String cwriter = c.getCwriter();
				System.out.printf("%-10d%-100s%-15s%-20s\n", cIdx, ccontent, cdate, cwriter);
			}
			System.out.println(line);
			System.out.print("[First]");
			System.out.print((pager.getGroupNo() >= 2) ? "[Prev] " : " ");
			for(int i=pager.getStartPageNo(); i<=pager.getEndPageNo(); i++) {
				if(i == pager.getPageNo()) {
					System.out.print("(" + i + ")" + ((i != pager.getEndPageNo()) ? ", " : ""));
				} else {
					System.out.print(i + ((i != pager.getEndPageNo()) ? ", " : ""));
				}
			}
			System.out.print((pager.getGroupNo() < pager.getTotalGroupNo()) ? " [Next]" : " ");
			System.out.println("[Last]\t[Close]");
			
			System.out.println("1. 페이지 이동 | 2. 댓글 쓰기 | 3. 댓글 삭제 | 4. 댓글 메뉴 끄기");
			String cmd = sc.nextLine();
			switch(cmd) {
				case "1":
					System.out.println("F: 첫페이지, P: 이전 페이지, N: 다음 페이지, L: 마지막 페이지, C: 종료, 숫자: 해당 페이지 이동");
					System.out.println("");
					String select = sc.nextLine();
					
					if (select.equals("f") || select.equals("F")) {
						getFirstPage(totalCommentNum);
					} else if (select.equals("p") || select.equals("P")) {
						getPrevGroup(totalCommentNum); // 이전 페이지 그룹 1, 2, 3
					} else if (select.equals("n") || select.equals("N")) {
						getNextGroup(totalCommentNum); // 다음 페이지 그룹 ex) 4, 5, 6
					} else if (select.equals("l") || select.equals("L")) {
						getLast(totalCommentNum);
					} else if(select.equalsIgnoreCase("c")) {
						return 1;
					} else {
						if(checkBno(select)) {
							getPage(Integer.parseInt(select), totalCommentNum);
						} else {
							System.out.println("잘못된 입력입니다.");
						}						
					}
					break;
				case "2":
					insertComment(bno, nowUser);	// 댓글쓰기
					break;
				case "3":
					deleteComment(nowUser);			// 댓글 지우기
					break;
				case "4":
					System.out.println("댓글 메뉴가 종료됩니다.");
					return 1;
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요");
					break;
			}
			result = 1;
		}		
	}
	
	// 댓글 쓰기
	public int insertComment(int bno, String cwriter) {
		// cno, ccontent, cdate, cwriter, bno
		Comment comment = new Comment();
		System.out.println("댓글 내용 입력(아무 내용을 입력하지 않을시 입력이 취소됩니다.)");
		System.out.print("내용 입력>");
		String ccontent = sc.nextLine();
		if(!ccontent.trim().equals("")) {
			comment.setCcontent(ccontent);
			comment.setBno(bno);
			comment.setCwriter(cwriter);
			return commentDao.insert(comment);
		} else {
			System.out.println("입력이 취소됩니다.");
			return -1;
		}
	}

	
	// 댓글 삭제
	public int deleteComment(String nowUser) {
		System.out.println("삭제할 게시글의 번호를 적어주세요(아무것도 입력하지 않을시 이전 화면으로 돌아갑니다.)");
		System.out.print("삭제할 댓글 번호 > ");
		String strTargetIdx = sc.nextLine();
		
		if(strTargetIdx.trim().equals("")) {
			System.out.println("이전 화면으로 돌아갑니다.");
			return -1;
		}
		
		if(!checkBno(strTargetIdx)) {
			System.out.println("잘못된 입력 양식입니다. 이전 화면으로 돌아갑니다.");
			return -1;
		} else {
			int targetIdx = Integer.parseInt(strTargetIdx);
			Comment deleteComment = boardComments.get(targetIdx-1);
			if(deleteComment.getCwriter().equals(nowUser)) {
				return commentDao.delete(deleteComment);
			} else {
				System.out.println("댓글은 작성자만 삭제할 수 있습니다.");
				return -1;
			}
		}
	}
	
	// 입력된 댓글 번호에 대한 유효성 검사
	private boolean checkBno(String keyword) {
		// 문자를 int 타입으로 바꿀 시 NumberFormatException이 일어나므로 이를 활용
		try {
			int no = Integer.parseInt(keyword);	// 문자라면 catch 부분에서 false를 리턴
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	// 페이징 메뉴
	private void getFirstPage(int totalCommentNum) {
		pager = new Pager(5, 3, totalCommentNum, 1);
	}

	private void getPrevGroup(int totalCommentNum) {
		if(pager.getStartPageNo() != 1)
			pager = new Pager(5, 3, totalCommentNum, pager.getStartPageNo() - 1);
	}

	private void getNextGroup(int totalCommentNum) {
		pager = new Pager(5, 3, totalCommentNum, pager.getEndPageNo() + 1);
	}

	private void getLast(int totalCommentNum) {
		pager = new Pager(5, 3, totalCommentNum, pager.getTotalPageNo());
	}

	private void getPage(int pageNo, int totalCommentNum) {
		pager = new Pager(5, 3, totalCommentNum, pageNo);
	}
}
