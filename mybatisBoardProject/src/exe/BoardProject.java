package exe;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import config.SqlSessionManager;
import dao.BoardDao;
import dao.UserDao;
import dto.Board;
import dto.Pager;
import dto.User;
import service.PagerService;
import service.PrintService;
import service.UserService;

public class BoardProject {

	public static void main(String[] args) {
		try(SqlSession session = SqlSessionManager.getSqlSession()){		
			Board board = new Board();
			Scanner scanner = new Scanner(System.in);

			PagerService pagerService = new PagerService();
			PrintService printService = new PrintService();
			UserService userService = new UserService();
			
			User user = null;
			boolean flag = false;
			boolean run = true;
			String selectNum;
			
			BoardDao boardDao = session.getMapper(BoardDao.class);
			UserDao userDao = session.getMapper(UserDao.class);
			
			Pager pager = new Pager(10,5,boardDao.selectTotalRowCount(),1);
			
			while(run) {
				
				pagerService.printPage(pager,boardDao,flag);
				
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
									user = userService.isLogined(userDao);
									if(user != null)
										System.out.println("userid: " + user.getUserId());
									break;
								case "2":
									System.out.println("회원가입 ");
									userService.isSignin(userDao);
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
									pager = pagerService.movePage(pager, boardDao);
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
									pager = pagerService.movePage(pager, boardDao);
									break;
								case "4":
									System.out.println("[게시글을 확인합니다.]");
									printService.printView(board, user.getUserId(), boardDao);
									break;
								case "5":
									System.out.println("[게시글을 작성합니다.]");
									printService.printWrite(board, user.getUserId(), boardDao);
									break;
								case "6":
									System.out.println("[게시글을 수정합니다.]");
									printService.printModify(board, user.getUserId(), boardDao);
									break;
								case "7":
									System.out.println("[게시글을 삭제합니다.]");
									printService.printDelete(board, user.getUserId(), boardDao);
									break;
								case "8":
									System.out.println("로그아웃 ");
									user = userService.islogout(userDao);
									System.out.println("userid: " + user);
									break;
								case "9":
									System.out.println("회원 탈퇴");
									userService.isSignout(userDao);
									user = null;
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
						//e.printStackTrace();
						continue;
					}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
