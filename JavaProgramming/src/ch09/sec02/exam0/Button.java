package ch09.sec02.exam0;

public class Button {
	//field 선언
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	//버튼을 클릭했을 때 실행하는 메소드
	void touch() {
		listener.onClick();
	}
	//중첩 인터페이스
	static interface OnClickListener{
		void onClick();
	}

}
