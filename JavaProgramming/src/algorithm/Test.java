package algorithm;

import java.util.Scanner;

public class Test {

   public static void main(String[] args) {
      
	      boolean run = true;//while 문 반복을 위한 변수
	      Scanner scanner = new Scanner(System.in);//입력을 위한 선언 
	      
	      String[][] notice = new String[100][4]; //다차원 배열을 사용하여 게시판 생성 { { 게시글 번호, 제목, 글쓰니, 내용 } }
	      int boardNum = 0; //게시글 번호 저장용
	      //100부터 1까지 for문
	      while(run) {//run이 false 될 때 까지 수행
	         System.out.println("-----------------------------------------------------------");
	         System.out.println("번호   제목                            글쓴이                  ");
	         System.out.println("-----------------------------------------------------------");
	         //중첩 반복문을 사용하여 내림차순 정렬(게시글 번호와 a의 값이 같을 경우에만 출력)
	         for(int a=100;a>0;a--) {
	            String strA = String.valueOf(a);//int형인 a를 String형태로 변환
	            for(String[] n:notice) {
	               if(n[0] != null && n[0].equals(strA)) {
	                  System.out.println(n[0] + "      " + n[1] + "                          " + n[2]);
	               }
	               //System.out.println(n[0] + "      " + n[1] + "                          " + n[2]);
	               
	            }
	         }
	         
	         System.out.println("-----------------------------------------------------------");
	         System.out.println("메뉴 : 1.생성|2.보기|3.수정|4.삭제|5.종료");
	     
	         
	         String strMenu = null;
	         while(true) {//메뉴 선택이 공백일 경우 다시 입력받기
	            System.out.print("선택:");
	            strMenu = scanner.nextLine();
	            if(strMenu.replace(" ", "").equals("")) {
	               System.out.println("번호를 입력해주세요.");
	               continue;
	            }
	            break;//공백이 아닌 경우 while문 탈출
	         }

	         int menu = Integer.parseInt(strMenu);//메뉴 int형으로 변환
	         
	         if(menu == 1) {
	            //게시물 100개 넘어가지 않게 오류처리 해야함
	            //String 최대 입력 넘어가는 오류 어찌 잡지
	            int count = 0;
	            for(int a=0;a<100;a++) {
	               if(notice[a][0] == null) {
	                  count += 1;
	               }
	            }
	            if(count == 0) {
	               System.out.println("게시판이 가득찼습니다.");
	               continue;
	            }
	            boardNum += 1;
	            System.out.println("[ 새글쓰기 ]");
	            //내용을 입력하지 않을경우 반복
	            String title = null;
	            String name = null;
	            String text = null;
	            while(true) { //제목 공백 막기
	               System.out.print("제목:");
	               title = scanner.nextLine();
	               if(title.replace(" ", "").equals("")) {
	                  System.out.println("제목을 입력하여 주세요.");
	                  continue;
	               }
	               break;
	            }   
	            while(true) { //글쓰니 공백 막기
	               System.out.print("글쓴이:");
	               name = scanner.nextLine();
	               if(name.replace(" ", "").equals("")) {
	                  System.out.println("글쓰니를 입력하여 주세요.");
	                  continue;
	               }
	               break;
	            }
	            while(true) { //내용 공백 막기
	               System.out.print("내용:");
	               text = scanner.nextLine();
	               if(text.replace(" ", "").equals("")) {
	                  System.out.println("내용을 입력하여 주세요.");
	                  continue;
	               }
	               break;
	            }
	            
	            //게시판 null 찾아 저장하기
	            for(int i=0;i<100;i++) {
	               if (notice[i][0] == null) {
	                
	                  notice[i][0] = String.valueOf(boardNum);
	                  notice[i][1] = title;
	                  notice[i][2] = name;
	                  notice[i][3] = text;
	                  break;//저장했으면 멈추기
	               }
	            }
	            
	            
	            
	         }else if(menu == 2) {//보기
	            //게시판에 글이 없으면 보기 선택 x or 번호 선택했을떄 null 일때만 오류 값 잡기
	            
	            System.out.print("게시물 번호 : ");
	            String num = scanner.nextLine();
	            boolean flag = false;
	            for(String[] n : notice) {
	               if(n[0] != null && n[0].equals(num)) {
	                  flag = true;
	                  System.out.println("[글 보기]");
	                  System.out.println("번호 : " + n[0]);
	                  System.out.println("제목 : " + n[1]);
	                  System.out.println("글쓴이 : " + n[2]);
	                  System.out.println("내용 : " + n[3]);
	                  break;
	               }
	            }
	            
	            if(flag == false) {
	               System.out.println("존재하지 않는 번호입니다.");
	            }
	         }else if(menu == 3) {//수정 
	            
	            System.out.print("게시물 번호 : ");
	            String num = scanner.nextLine();
	            boolean flag = false;
	            for(int i=0;i<100;i++) {
	               if(notice[i][0] != null && notice[i][0].equals(num)) {
	                  //제목이랑 내용을 선택하여 바꾸고 싶을 경우엔 어떤 식으로 할까?
	                  //공백일 경우에 원래 내용으로 유지하기?
	                  System.out.println("수정을 원하는 않은 부분은 공백처리 해주세요.");
	                  flag = true;

	                  String newTitle = null;
	                  String newText = null;
	                  
	                  System.out.print("제목:");
	                  newTitle = scanner.nextLine();
	                  if(!newTitle.replace(" ", "").equals("")) {
	                     notice[i][1] = newTitle;
	                  }
	                  
	                  System.out.print("내용:");
	                  newText = scanner.nextLine();
	                  if(!newText.replace(" ", "").equals("")) {
	                     notice[i][3] = newText;
	                  }
	                  System.out.println("변경되었습니다.");
	                  break;
	               }
	            }
	            if(flag == false) {
	               System.out.println("존재하지 않는 번호입니다.");
	            }
	         }else if(menu == 4) {//삭제
	            System.out.print("게시물 번호 : ");
	            String num = scanner.nextLine();
	            boolean flag = false;
	            
	            for(int i=0;i<100;i++) {
	               if(notice[i][0] != null && notice[i][0].equals(num)) {
	                  flag = true;
	                  for(int a = 0;a<4;a++) {
	                     notice[i][a] = null;   
	                  }
	                  
	                  System.out.println("삭제되었습니다.");
	                  break;
	               }
	            }
	            if(flag == false) {
	               System.out.println("존재하지 않는 번호입니다.");
	            }
	            
	         }else if(menu == 5) {
	            run = false;
	            System.out.println("게시판 프로그램을 종료합니다.");
	         }else {
	            System.out.println("번호를 잘못 입력하셨습니다.");
	         }
	      }
   }

}