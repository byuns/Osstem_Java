package ch06.sec06.exam07;

public class BoardExample {

	public static void main(String[] args) {
		Board board = new Board();
		String[] comment = {"아주 좋아요"};
		//값 저장
		board.setNo(10);
		board.setTitle("자바 프로그래밍");
		board.setWriter("홍길동");
		board.setContent("오늘도 자바 공부를 합니다.");
		board.setOpen(true);
		board.setComment(comment) ;
		
		//값 출력
		System.out.println(board.getNo());
		System.out.println(board.getTitle());
		System.out.println(board.getWriter());
		System.out.println(board.getContent());
		System.out.println(board.isOpen());
		System.out.println(board.getComment()[0]);

	}

}
