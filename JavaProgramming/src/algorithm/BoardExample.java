package algorithm;
import java.util.Scanner;

public class BoardExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int select_Num,search_Num; // 번호 선택, 찾는 문서 번호
		int document_Num = 0; // 문서 번호
		String title,writer,contents; // 제목, 글쓴이, 내용
		String title_mod,contents_mod; // 수정 제목, 수정 내용
		String select_Num_Check;
		String[][] document = new String[100][4]; // 최대 100개의 글, 4가지 항목
		
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("번호	제목			글쓴이");
			System.out.println("-------------------------------------------------");
			//목록 출력
			for(int i=document.length-1; i>-1;i--) {
				if(document[i][0] != null) {
					System.out.println(document[i][0] + "	" + document[i][1]+"			" + document[i][2]);
				}
			}
			System.out.println("-------------------------------------------------");
			System.out.println("메뉴 : 1.생성 | 2.보기 | 3.수정 | 4.삭제 | 5.종료");
			//넘버 선택
			System.out.print("선택 : ");
			select_Num = Integer.parseInt(scan.nextLine());
			//각 넘버 선택 시 출력 화면 및 설정 가능
			if(select_Num == 1) { // 생성
				
				document_Num += 1;
				System.out.println("[새글쓰기]");
				System.out.print("제목 : ");
				title = scan.nextLine();
				System.out.print("글쓴이 : ");
				writer = scan.nextLine();
				System.out.print("내용 : ");
				contents = scan.nextLine();
				//정수로 1씩 증가되는 document_Num를 String으로 변경
				document[document_Num-1][0] = Integer.toString(document_Num);
				document[document_Num-1][1] = title;
				document[document_Num-1][2] = writer;
				document[document_Num-1][3] = contents;
				
			}
			else if(select_Num == 2) { // 보기
				System.out.print("게시물 번호 입력 : ");
				search_Num = Integer.parseInt(scan.nextLine());
				
				if(document[search_Num-1][0] != null) { // 해당 게시물 번호가 null이 아닐 때 실행(글이 있는지 없는지 파악)
					System.out.println("[글 보기]");
					System.out.println("번호 : " + document[search_Num-1][0]);
					System.out.println("제목 : " + document[search_Num-1][1]);
					System.out.println("글쓴이 : " + document[search_Num-1][2]);
					System.out.println("내용 : " + document[search_Num-1][3]);
				}
				else { // 해당 게시물 번호가 null일 때 실행
					System.out.println("번호에 맞는 글이 없습니다. \n다시 입력해주세요.");
				}
			}
			else if(select_Num == 3) { // 수정
				System.out.print("게시물 번호 입력 : ");
				search_Num = Integer.parseInt(scan.nextLine());
				
				if(document[search_Num-1][0] != null) {
					System.out.println("[글 수정]");
					System.out.print("제목 : ");
					title_mod = scan.nextLine();
					System.out.print("내용 : ");
					contents_mod = scan.nextLine();
				
					document[search_Num-1][1] = title_mod;
					document[search_Num-1][3] = contents_mod;
				}
				else {
					System.out.println("번호에 맞는 글이 없습니다. \n다시 입력해주세요.");
				}
			}
			else if(select_Num == 4) { // 삭제
				System.out.print("게시물 번호 입력 : ");
				search_Num = Integer.parseInt(scan.nextLine());
				
				if(document[search_Num-1][0] != null) {
					for(int i = 0; i<document[search_Num-1].length;i++) {
						document[search_Num-1][i] = null;
					}
				}
				else {
					System.out.println("번호에 맞는 글이 없습니다. \n다시 입력해주세요.");
				}
				
			}
			else if(select_Num == 5) { // 종료
				System.out.println("게시판 프로그램을 종료합니다.");
				run = false;
			}
			else { // 1~5 이외의 숫자 입력 시 재입력
				System.out.println("번호를 잘못입력했습니다.\n다시 입력해주세요.");
			}
			
		}
		
		
	}

}
