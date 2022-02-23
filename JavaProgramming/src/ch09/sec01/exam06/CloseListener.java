package ch09.sec01.exam06;

public class CloseListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("윈도우를 닫습니다.");
	}
}
