package ch14.verify;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ch14.sec02.exam06.Board;

public class BoardService {//기능들을 제공해주는 객체
	private int bno = 0;
	private boolean flag;
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
	private List<Board> boardList = new ArrayList();

	public void print() { // 출력 메소드
		System.out.println("번호	제목	글쓴이		작성일자");
		for(int i = boardList.size()-1; i>=0; i--) {
			System.out.println(boardList.get(i).getBno() + "   " + boardList.get(i).getTitle() + "   " + boardList.get(i).getWriter() 
			+ "   " +sdf.format(boardList.get(i).getDate()) );
		}
	}
	
	public void create() { // 생성 메소드, 모든 입력란은 공백이 불가하다.
		String title;
		String writer;
		String content;
		
		while(true) {
			System.out.print("제목 : ");
			title = sc.nextLine();
			if(!title.replace(" ", "").equals("")) {
				break;
			}
			System.out.println("[제목은 공백이 불가합니다.] \n다시 입력해주세요.");
		}
		while(true) {
			System.out.print("글쓴이 : ");
			writer = sc.nextLine();
			if(!writer.replace(" ", "").equals("")) {
				break;
			}
			System.out.println("[글쓴이는 공백이 불가합니다.] \n다시 입력해주세요.");
		}
		while(true) {
			System.out.print("내용 : ");
			content = sc.nextLine();
			if(!content.replace(" ", "").equals("")) {
				break;
			}
			System.out.println("[내용은 공백이 불가합니다.] \n다시 입력해주세요.");
		}
		bno++; // 게시물 번호 증가
		Date date = new Date(); 
		boardList.add(new Board(bno,title,writer,content,date));
		
	}
	
	public void view(int numView) throws Exception { // 목록 확인 메소드
		System.out.println("번호 : " + boardList.get(numView-1).getBno() + 
				"  제목 : "  + boardList.get(numView-1).getTitle() +
				"  글쓴이 : "+ boardList.get(numView-1).getWriter());
		System.out.println("작성일자 : " + sdf.format(boardList.get(numView-1).getDate()));
		System.out.println("내용 : " + boardList.get(numView-1).getContent());
		
	}
	
	public void lookup(String writer) { // 작성자로 게시글 조회
		flag = false;
		System.out.println("번호	제목	글쓴이		작성일자\n");
		for(int i = boardList.size()-1; i>=0; i--) {
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
	
	public void modify(int numMod, String writer) throws Exception { // 수정 메소드
		flag = false;
		for(Board board : boardList) {
			if(board.getBno() == numMod) {
				if(board.getWriter().equals(writer)) {
					System.out.println("수정을 원하지 않으면 공백을 입력해주세요.");
					System.out.print("제목 : ");
					String title = sc.nextLine();
					System.out.print("내용 : ");
					String content = sc.nextLine();
					String modify = sdf.format(boardList.get(numMod-1).getDate()); // 수정 시각을 내용에 함께 추가한다.
				
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
				else {
					System.out.println("회원님은 작성자가 아니기 때문에 수정이 불가합니다.");
				}
			}
		}
		if(flag != true) {
			System.out.println("해당 게시물은 존재하지 않습니다.");
		}
	}
	
	public void delete(int numDel){ // 삭제 메소드
		flag = false;
		for(int i = 0; i<boardList.size(); i++) {
			if(boardList.get(i).getBno() == numDel) { // 넘겨 받은 게시물 번호와 객체 리스트 안에 있는 Bno 값이 일치하면 삭제
				boardList.remove(i);
				System.out.println(numDel + "번 게시물이 삭제되었습니다.");
				flag = true;
				break;
			}
		}
		if(flag != true) { // 일치하지 않을 경우 해당 번호의 게시물은 존재하지 않음
			System.out.println("해당 게시물은 존재하지 않습니다.");
		}	
	}
	
	public void save() throws Exception{ // 파일 저장 메소드
		String[] special = new String[]{"/", "\\", ":","*","?","\"","<",">","|"};
		String fileName;
		String filePath = null;
		flag = true;
		System.out.println("[게시판을 파일로 저장합니다.]");
		while(true) {
			System.out.print("저장할 파일 이름을 입력해주세요 : ");
			fileName = sc.nextLine();
			for(int i=0; i<special.length;i++) {
				if(fileName.contains(special[i])) {
					System.out.println("파일 이름에 특수문자는 불가합니다.");
					flag = false;
					break;
				}
				else {
					flag = true;
				}
			}
			if(flag == true) {
				filePath = "C:/Temp/" + fileName + ".db";
				break;
			}
		}
		System.out.println("저장 경로 :" + filePath);
		System.out.println("[저장 완료]");
		
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			
		oos.writeObject(boardList);
		oos.flush();
		oos.close();
			
	}
	
	public void loading() {// 파일 불러오기 메소드
		String[] special = new String[]{"/", "\\", ":","*","?","\"","<",">","|"};
		String fileName;
		String filePath = null;
		
		while(true) {
			flag = true;
			while(true) {
				System.out.print("불러올 파일 이름을 입력해주세요 : ");
				fileName = sc.nextLine();
				for(int i=0; i<special.length;i++) {
					if(fileName.contains(special[i])) {
						System.out.println("파일 이름에 특수문자는 불가합니다.");
						flag = false;
						break;
					}
					else {
						flag = true;
					}
				}
				if(flag == true) {
					filePath = "C:/Temp/" + fileName + ".db";
					break;
				}
			}
			try {
				FileInputStream fis = new FileInputStream(filePath);
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<Board> list = (List<Board>) ois.readObject();
				
				for(Board board : list) {
					boardList.add(new Board(board.getBno(),board.getTitle(),board.getContent(),board.getWriter(),board.getDate()));
					bno++;
				}		
				ois.close();
				System.out.println("파일을 불러온 경로 : " + filePath);
				System.out.println("[파일 불러오기 완료]");
				break;
			}catch(IOException e) {
				System.out.println("해당 파일이 존재하지 않습니다.");
				while(true) {
					System.out.println("새로운 게시판을 만들겠습니까?(y/n)");
					String select = sc.nextLine();
					if(select.equals("y")) {
						flag = true;
						break;
					}else if(select.equals("n")){
						System.out.println("[파일 이름을 다시 입력합니다.]");
						flag = false;
						break;
					}else {
						System.out.println("\'y\' 또는 \'n\'을 입력해주세요.");
					}
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			if(flag == true) {
				break;
			}
		}

	}
}
