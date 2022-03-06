package ch14.verify01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardService {//기능들을 제공해주는 객체
	private int bno = 0; // 게시글 번호
	private boolean flag; // 반복문이나 게시글이 존재하는지 확인하는 플래그 
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm"); // date 출력 형식 정의
	private List<Board> boardList = new ArrayList<Board>();

	public void print(String user) { //게시글 목록 출력 메소드
		System.out.println("번호	제목	글쓴이		작성일자");
		for(int i = boardList.size()-1; i>=0; i--) { // 내림차순
			if(user == null) { //비회원일 경우 유저공개 안보이게 처리
				if(boardList.get(i).isOpen()) {//true는 공개
					System.out.println(boardList.get(i).getBno() + "   " + boardList.get(i).getTitle() + "   " + boardList.get(i).getWriter() 
							+ "   " +sdf.format(boardList.get(i).getDate()) );
				}else{
					System.out.println(boardList.get(i).getBno() + "   유저공개제목    유저공개글쓴이   " +sdf.format(boardList.get(i).getDate()) );
				}
			}else {//회원일경우 모두 공개
				System.out.println(boardList.get(i).getBno() + "   " + boardList.get(i).getTitle() + "   " + boardList.get(i).getWriter() 
						+ "   " +sdf.format(boardList.get(i).getDate()) );
			}
			
		}
	}
	public void create(String userName) throws Exception{ // 게시글 생성 메소드, 모든 입력란은 공백이 불가하다.
		String title;
		String content;
		boolean open;
		
		while(true) {
			System.out.print("제목 : ");
			title = sc.nextLine();
			if(!title.replace(" ", "").equals("")) {
				break;
			}
			System.out.println("[제목은 공백이 불가합니다.] \n다시 입력해주세요.");
		}
		
		while(true) {
			System.out.print("내용 : ");
			content = sc.nextLine();
			if(!content.replace(" ", "").equals("")) {
				break;
			}
			System.out.println("[내용은 공백이 불가합니다.] \n다시 입력해주세요.");
		}
		while(true) {
			System.out.print("공개여부(y/n) : ");
			String select = sc.nextLine();
			if(select.equals("y")) {
				open = true;
				break;
			}else if(select.equals("n")) {
				open = false;
				break;
			}else {
				System.out.println("\'y\'또는 \'n\'을 입력해주세요");
			}
		}
		bno++; // 게시물 번호 증가
		
		Date date = new Date(); //현재 시각 저장
		boardList.add(new Board(bno,title,userName,content,date,open));//객체 생성 후 리스트에 저장
		
		save();
	}
	
	public void view(int numView, String user) throws Exception { // 게시글 상세 확인 메소드
		flag = false;
		for(Board board : boardList) {
			if(board.getBno() == numView) {
				flag = true;
				if(user == null) {
					if(board.isOpen()) {
						System.out.println("번호 : " + board.getBno() + 
								"  제목 : "  + board.getTitle() +
								"  글쓴이 : "+ board.getWriter());
						System.out.println("작성일자 : " + sdf.format(board.getDate()));
						System.out.println("내용 : " + board.getContent());
						break;
					} else {
						System.out.println("로그인 후 이용해주세요.");
						break;
					}
				} else {
					if(board.getWriter().equals(user)) {
						System.out.println("번호 : " + board.getBno() + 
								"  제목 : "  + board.getTitle() +
								"  글쓴이 : "+ board.getWriter());
						System.out.println("작성일자 : " + sdf.format(board.getDate()));
						System.out.println("내용 : " + board.getContent());
						
						while(true) {
							System.out.print("수정 또는 삭제 하시겠습니다? (y/n): ");
							String select = sc.nextLine();
							
							if(select.equals("y")) {
								System.out.println("------------------------------------------------------------------");
								System.out.println("1. 수정하기 \t 2.삭제하기");
								System.out.println("------------------------------------------------------------------");
								System.out.print("선택: ");
								int selNum = Integer.parseInt(sc.nextLine());
								if (selNum == 1) {
									modify(numView);
									break;
								} else if (selNum == 2) {
									delete(numView);
									break;
								} 
							} else if (select.equals("n")) {
								System.out.println("메뉴로 돌아갑니다.");
								//flag = true;
								break;
							}
							else {
								System.out.println("\'y\'또는 \'n\'을 입력해주세요");
							}
						}
							break;
					} else {
						System.out.println("번호 : " + board.getBno() + 
								"  제목 : "  + board.getTitle() +
								"  글쓴이 : "+ board.getWriter());
						System.out.println("작성일자 : " + sdf.format(board.getDate()));
						System.out.println("내용 : " + board.getContent());
						break;
					}
				}
			}
		}
		
		if(flag != true) {
			System.out.println("해당 게시글이 존재하지 않습니다.");
		}
	}
	
	public void lookup(String writer) { // 작성자로 게시글 조회
		
		flag = false;  //해당 게시글이 존재하는지 판단하는 플래그
		System.out.println("번호	제목	글쓴이		작성일자\n");
		for(int i = boardList.size()-1; i>=0; i--) {//내림차순 정렬
			if(boardList.get(i).getWriter().equals(writer)) {
				flag = true;
			System.out.println(boardList.get(i).getBno() + "   " + boardList.get(i).getTitle() + "   " + boardList.get(i).getWriter() 
			+ "   " +sdf.format(boardList.get(i).getDate()) );
			}
		}
		if(flag != true) {
			System.out.println("해당 글쓴이의 게시글이 존재하지 않습니다.");
		}
	}
	
	public void modify(int numMod) throws Exception { // 수정 메소드
		flag = false; //해당 게시글이 존재하는지 판단하는 플래그
		for(Board board : boardList) {
			if(board.getBno() == numMod) { // 받아온 게시글 번호와 저장된 번호와 같을 때 실행
					System.out.println("수정을 원하지 않으면 공백을 입력해주세요.");
					System.out.print("제목 : ");
					String title = sc.nextLine();
					System.out.print("내용 : ");
					String content = sc.nextLine();
					String modify = sdf.format(board.getDate()); // 수정 시각을 내용에 함께 추가한다.
				
					// 수정을 원치 않는 부분은 공백처리
					if(title.replace(" ", "").equals("")) {
						if(!content.replace(" ", "").equals("")) { // 내용만 수정
							board.setContent(content + "\n(" + modify + "에 내용만 수정됨)");
						}
					}else {
						if(!content.replace(" ", "").equals("")) {// 제목 및 내용 모두 수정
							board.setTitle(title);
							board.setContent(content+"\n(" + modify + "에 제목 및 내용이 모두 수정됨)");
						}else {// 제목만 수정
							board.setTitle(title);
							board.setContent(board.getContent() + "\n(" + modify + "에 제목만 수정됨)" );
						}
					}
					flag = true;
					break;
			}
		}
		if(flag != true) {
			System.out.println("해당 게시물은 존재하지 않습니다.");
		}
		save();
	}
	
	public void delete(int numDel) throws Exception{ // 삭제 메소드
		flag = false;//해당 게시글이 존재하는지 판단하는 플래그
		try {
			for(int i = 0; i<boardList.size(); i++) {
				if(boardList.get(i).getBno() == numDel) { // 넘겨 받은 게시물 번호와 객체 리스트 안에 있는 Bno 값이 일치하면 삭제
					boardList.remove(i);
					System.out.println(numDel + "번 게시물이 삭제되었습니다.");
					flag = true;
					break;
				}
			}
		} catch(ConcurrentModificationException e) {
            System.out.println();
    }
		if(flag != true) { // 일치하지 않을 경우 해당 번호의 게시물은 존재하지 않음
			System.out.println("해당 게시물은 존재하지 않습니다.");
		}
		save();
	}
	
	public String save() throws Exception{ // 파일 저장 메소드
		String filePath = "C:/Temp/project/board.db";

		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			
		oos.writeObject(boardList);
		oos.flush();
		oos.close();
		
		return filePath;
	}
	
	public void loading() {// 파일 불러오기 메소드
		
		try {//파일 불러오기
			File file = new File("C:/Temp/project/board.db");
			
			if(file.exists() == false) {
				file.createNewFile();
			}else {
				FileInputStream fis = new FileInputStream("C:/Temp/project/board.db");
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<Board> list = (List<Board>) ois.readObject();
				for(Board board : list) {
					boardList.add(new Board(board.getBno(),board.getTitle(),board.getWriter(),board.getContent(),board.getDate(),board.isOpen()));
					bno = board.getBno();
				}
				ois.close();
				System.out.println("[파일 불러오기 완료]");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			

	}
}
