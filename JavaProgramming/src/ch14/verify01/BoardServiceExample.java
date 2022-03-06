package ch14.verify01;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class BoardServiceExample {//객체 생성 및 실행

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			BoardService boardService = new BoardService();//게시판 구현 객체 생성
			UserService userService = new UserService();//유저 구현 객체 생성
			boolean flag = true;//while 탈출용
			boolean login = false;//로그인 확인
			String userName = null;//로그인 유저
			boardService.loading();
			
			while(flag) {//게시판 시작
				try {
          
						if(userName != null){ // 로그인 시
					      System.out.println("------------------------------------------------------------------");
					      System.out.println("1.목록보기 | 2.상세보기 | 3.검색 | 4.종료 | 5.작성하기 | 6.로그아웃 ");
					      System.out.println("------------------------------------------------------------------");
						}
						else{//로그인 안할때
					      System.out.println("------------------------------------------------------------------");
					      System.out.println("1.목록보기 | 2.상세보기 | 3.검색 | 4.종료 | 7.로그인 | 8.회원가입 ");
					      System.out.println("------------------------------------------------------------------");
						}
						System.out.print("선택 : ");

						int selectNum = Integer.parseInt(sc.nextLine());
						if(selectNum < 1 || selectNum > 8) { // 1~7번만 입력 가능하도록 함
							System.out.println("1~8번을 입력해주세요.");
							continue;
						}
						else {
							switch(selectNum) { // BoardService 객체가 가진 각각의 메소드들에 입력한 '게시글 번호'를 전달한다.
							case 1: // 목록보기
								//*** 유저일때 유저 공개 보이는거 수정
								boardService.print(userName);
								break;
							case 2://상세보기
								System.out.print("상세히 볼 게시물 번호를 입력해주세요 : ");
								int numView = Integer.parseInt(sc.nextLine());
								boardService.view(numView, userName);
								break;
							case 3: // 검색
								System.out.print("조회할 글쓴이를 입력해주세요 : ");
								String searchWriter = sc.nextLine();
								boardService.lookup(searchWriter);
								break;
							case 4: // 종료
								flag = false;
								System.out.println("게시판이 종료됩니다.");
								break;
							case 5: // 작성하기
								if(userName != null) {
									boardService.create(userName);
								}else {
									System.out.println("로그인 후 이용 가능합니다.");
								}
								break;
							case 6: // 로그아웃
								if(userName != null) {
									System.out.println("로그아웃 합니다.");
									userName = null;
								}
								else {
									System.out.println("로그인 후 이용 가능합니다.");
								}
								break;
							case 7: // 로그인
								if(userName != null) {
									System.out.println("로그인 상태입니다.");
									break;
								}else {
									while(true) {
										System.out.println("[ 로그인 ] 뒤로가려면 아이디 공백 처리 하세요.");
										String nowlogin = userService.loginUser();
										if(nowlogin != null && nowlogin.equals("back")) {
											break;
										}else if(nowlogin != null && !nowlogin.equals("pwd")) {//로그인 성공
											userName = nowlogin;
											break;
										}
									}
								}
								break;
							case 8: 
								System.out.println("[ 회원 가입 ]");
								userService.signUp();
								break;
							}
					}
				}catch(NumberFormatException e) {
					System.out.println("정수를 입력해 주세요.");
				}catch(IndexOutOfBoundsException e) {
					System.out.println("존재하는 게시물 번호를 입력해주세요.");
				}catch(IOException e) {
					System.out.println("해당 폴더 및 파일이 존재하지 않습니다. \n다시 입력해주세요.");
				}
			}
		
		}catch(Exception e) {//이외 예외에 대한 확인 [디버깅용]
			e.printStackTrace();
		}
          

	}
}
