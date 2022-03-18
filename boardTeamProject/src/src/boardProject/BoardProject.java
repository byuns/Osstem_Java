package boardProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import common.dto.Board;
import common.dto.User;
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
		
		User user = null;
		UserService userService = new UserService();
		
		
		Pager pager = new Pager(10,5,boardService.getTotalBoardNum(),1);
		int num=0;

		boolean isLogined = false;
//		String user = null;
		boolean run = true;
		String selectNum;
		boolean flag = false;
		
		while(run) {
			//게시글 목록 출력
			thumbnail();
			pagerService.printPage(pager,flag);
			try {
			// 로그인을 해야 게시글 작성 가능
				if(user == null) { // 비회원
					System.out.println("--------------------------------------------------------------");
					System.out.println("1.로그인 2.회원가입 3.조회순으로 보기 4.최신순으로 보기 5.페이지 이동 6.종료");
					System.out.println("--------------------------------------------------------------");
					System.out.print("선택 : ");
					selectNum = scanner.nextLine();
					
					switch(selectNum) {
						case "1":
							System.out.println("로그인  ");
							user = new User();
							user = userService.isLogined();
							System.out.println("userid: " + user.getUserId());
							break;
						case "2":
							System.out.println("회원가입 ");
							userService.isSignin();
							break;
						case "3":
							System.out.println("조회순으로 정렬합니다.");
							flag = true;
							break;
						case "4":
							System.out.println("최신순으로 정렬합니다.");
							flag = false;
		                    break;
						
						case "5":
							pager = pagerService.movePage(pager);
							break;
						case "6":
							run = false;
							System.out.println("게시판 서비스가 종료됩니다.");
							break;
						default:
							System.out.println("1~6번을 입력해주세요.");
					}
				}else { // 회원
					System.out.println("-------------------------------------------------------------");
					System.out.println("1.조회순으로 보기 2.최신순으로 보기 3. 페이지 이동 4.게시글 보기");
					System.out.println("5.작성하기 6.수정하기 7.삭제하기 8.로그아웃 9.회원탈퇴 10.종료");
					System.out.println("-------------------------------------------------------------");
					System.out.print("선택 : ");
					selectNum = scanner.nextLine();
					
					switch(selectNum){
						case "1":
							System.out.println("조회순으로 정렬합니다.");
							flag = true;
							break;
						case "2":
							System.out.println("최신순으로 정렬합니다.");
							flag = false;
		                    break;
						case "3":
							pager = pagerService.movePage(pager);
							break;
						case "4":
							System.out.println("[게시글을 확인합니다.]");
							printService.printView(board,user.getUserId());
							break;
						case "5":
							System.out.println("[게시글을 작성합니다.]");
							printService.printWrite(board, user.getUserId());
							break;
						case "6":
							System.out.println("[게시글을 수정합니다.]");
							printService.printModify(board, user.getUserId());
							break;
						case "7":
							System.out.println("[게시글을 삭제합니다.]");
							printService.printDelete(board, user.getUserId());
							break;
						case "8":
							System.out.println("로그아웃 ");
							user = userService.islogout();
							System.out.println("userid: " + user);
							break;
						case "9":
							System.out.println("회원 탈퇴");
							userService.isSignout();
							break;
						case "10":
							run = false;
							System.out.println("게시판 서비스가 종료됩니다.");
							break;
						default :
							System.out.println("1~10번을 입력해주세요.");
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
	
	public static void thumbnail() {
		File doc = new File(System.getProperty("user.dir")+"/src/thumbnail.txt");
        Scanner obj = null;
        try {
           obj = new Scanner(doc);
        } catch (FileNotFoundException e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
        }

        while (obj.hasNextLine()){
           System.out.println(obj.nextLine());
        }

	}
}
