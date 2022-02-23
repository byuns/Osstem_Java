package ch09.sec01.exam06;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();
		Button btnCancel = new Button();
		
		btn.setOnClickListener(new CallListener()); // 해당 Listener를 버튼에 등록
		btn.touch();
		
		btn.setOnClickListener(new MessageListener()); // 해당 Listener를 버튼에 등록
		btn.touch();
		
		Button btnClose = new Button();
		btnClose.setOnClickListener(new CloseListener());
		btnClose.touch();
		
		

		
	}

}
