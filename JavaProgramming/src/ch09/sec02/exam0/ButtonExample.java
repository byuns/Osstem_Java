package ch09.sec02.exam0;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();
		Button btnCancel = new Button();
		
		btn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("전화를 겁니다.");
			}
		}); // 해당 Listener를 버튼에 등록
		btn.touch();
		
		btn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("메세지를 보냅니다.");
				
			}
		}); // 해당 Listener를 버튼에 등록
		btn.touch();
		
		Button btnClose = new Button();
		btnClose.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("윈도우를 닫습니다.");
			
			}
		});
		btnClose.touch();
		
		

		
	}

}
