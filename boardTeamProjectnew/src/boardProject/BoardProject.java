package boardProject;

import java.util.Scanner;

import common.dto.Board;
import common.service.BoardService;
import common.service.PagerService;
import common.service.PrintService;
import common.service.UserService;



public class BoardProject {
	public static void main(String[] args) {
		ConnectionManager.init();
		Board board = new Board();
		Scanner scanner = new Scanner(System.in);
		BoardService boardService = new BoardService();
		PagerService pagerService = new PagerService();
		PrintService printService = new PrintService();
		
		UserService userService = new UserService();
		
		Pager pager = new Pager(10,5,boardService.getTotalBoardNum(),1);
		int num=0;

		boolean isLogined = false;
		String user = null;
		boolean run = true;
		String selectNum;
		
		while(run) {
			//게시글 목록 출력
			pagerService.printPage(pager);
			
			try {
			// 로그인을 해야 게시글 작성 가능
				if(!isLogined) { // 비회원
					System.out.println("--------------------------------------------------------------");
					System.out.println("1.로그인 2.회원가입 3.조회수 순으로 보기 4.페이지 이동 5.종료");
					System.out.println("--------------------------------------------------------------");
					System.out.print("선택 : ");
					selectNum = scanner.nextLine();
					
					switch(selectNum) {
						case "1":
							System.out.println("로그인  ");
							isLogined = userService.isLogined();
							System.out.println("userid: " + isLogined);
							break;
						case "2":
							System.out.println("회원가입 ");
							userService.isSignin();
							break;
						case "3":
							break;
						case "4":
							pager = pagerService.movePage(pager);
							break;
						case "5":
							run = false;
							System.out.println("게시판 서비스가 종료됩니다.");
							break;
						default:
							System.out.println("1~5번을 입력해주세요.");
					}
				}else { // 회원
					System.out.println("-------------------------------------------------------------");
					System.out.println("1.조회수 순으로 보기 2. 페이지 이동 3.게시글 보기 4.작성하기 5.수정하기 6.삭제하기 7.로그아웃 8.종료");
					System.out.println("-------------------------------------------------------------");
					System.out.print("선택 : ");
					selectNum = scanner.nextLine();
					
					switch(selectNum){
						case "1":
							break;
							case "2":
							pager = pagerService.movePage(pager);
							break;
						case "3":
							System.out.println("[게시글을 확인합니다.]");
							printService.printView(board);
							break;
						case "4":
							System.out.println("[게시글을 작성합니다.]");
							printService.printWrite(board);
							break;
						case "5":
							System.out.println("[게시글을 수정합니다.]");
							printService.printModify(board, user);
							break;
						case "6":
							System.out.println("[게시글을 삭제합니다.]");
							printService.printDelete(board, user);
							break;
						case "7":
							System.out.println("로그아웃 ");
							isLogined = userService.islogout();
							System.out.println("userid: " + isLogined);
							break;
						case "8":
							run = false;
							System.out.println("게시판 서비스가 종료됩니다.");
							break;
						default :
							System.out.println("1~8번을 입력해주세요.");
					}
				}
				System.out.println();
			}catch(NumberFormatException e) {
				System.out.println("올바른 값을 입력해주세요.");
			}catch(Exception e) {
				System.out.println("올바르게 입력해주세요.");
				continue;
			}
		}
	}
}
