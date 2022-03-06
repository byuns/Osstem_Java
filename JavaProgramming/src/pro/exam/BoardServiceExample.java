package pro.exam;

import java.io.IOException;
import java.util.Scanner;

public class BoardServiceExample {//객체 생성 및 실행

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			BoardService boardService = new BoardService();
			boolean flag = true;
			int pw = 0;
			
			while(true) { // 파일 불러오기
				System.out.println("불러올 파일이 있습니까.(y/n)");
				String select = sc.nextLine();
				if(select.equals("y")) {
					boardService.loading();
					break;
				}
				else if(select.equals("n")) {
					System.out.println("[새로운 게시판을 작성합니다.]");
					break;
				}else {
					System.out.println("\'y\'또는 \'n\'을 입력해주세요");
				}
			}
			while(flag) {
				try {
					
					//메인 메뉴 생성시 참고 용
			          //로그인시
						    //System.out.println("------------------------------------------------------------------");
						    //System.out.println("1.목록보기 |2.작성하기 |3.검색 |4.종료|5.로그아웃");
						    //System.out.println("------------------------------------------------------------------");
						    //로그인 안할때
						    //System.out.println("------------------------------------------------------------------");
						    //System.out.println("1.목록보기 |3.검색 |4.종료|6.로그인|7.회원가입");
						    //System.out.println("------------------------------------------------------------------");
					 
					/*int selectNum = Integer.parseInt(sc.nextLine());
					switch(selectNum) {
						case 1:
							boardService.print();
							break;
						case 2:
							if(login == true) {
								boardService.create();
							}else {
								System.out.println("로그인 후 이용 가능합니다.");
							}
							break;
						case 3:
							System.out.print("조회할 글쓴이를 입력해주세요 : ");
							String searchWriter = sc.nextLine();
							boardService.lookup(searchWriter);
							break;
						case 4:
							flag = false;
							System.out.println("게시판이 종료됩니다.");
							break;
							
						case 5://로그아웃
							if(login == true) {
								//로그아웃 코드
							}
							else {
								System.out.println("로그인 후 이용 가능합니다.");
							}
							break;
						case 6: //로그인
							break;
						case 7: //회원가입
							break;
					}*/
					
					
					
					
					
					
					
					
					System.out.println("------------------------------------------------------------------");
					System.out.println("1.목록보기 |2.작성하기 |3.글쓴이로 조회 |4.상세보기 |5.수정하기 |6.삭제하기 |7.파일저장 |8.종료");
					System.out.println("------------------------------------------------------------------");
					System.out.print("선택 : ");

					int selectNum = Integer.parseInt(sc.nextLine());
					if(selectNum < 1 || selectNum > 8) { // 1~8번만 입력 가능하도록 함
						System.out.println("1~8번을 입력해주세요.");
						continue;
					}
					else {
						switch(selectNum) { // BoardService 객체가 가진 각각의 메소드들에 입력한 '게시글 번호'를 전달한다.
						case 1: // 목록보기
							boardService.print();
							break;
						case 2: // 작성하기
							boardService.create();
							break;
						case 3: // 글쓴이로 게시글 조회
							System.out.print("조회할 글쓴이를 입력해주세요 : ");
							String searchWriter = sc.nextLine();
							boardService.lookup(searchWriter);
							break;
						case 4: // 상세보기
							System.out.print("상세히 볼 게시물 번호를 입력해주세요 : ");
							int numView = Integer.parseInt(sc.nextLine());
							boardService.view(numView);
							break;
						case 5: // 수정하기
							System.out.print("수정할 게시물 번호를 입력해주세요 : ");
							int numMod = Integer.parseInt(sc.nextLine());
							boardService.modify(numMod);
							break;
						case 6: // 삭제하기
							System.out.print("삭제할 게시물 번호를 입력해주세요 : ");
							int numDel = Integer.parseInt(sc.nextLine());
							boardService.delete(numDel);
							break;
						case 7: // 파일저장
							boardService.save();
							break;

						case 8: // 종료
							flag = false;
							System.out.println("게시판이 종료됩니다.");
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
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
