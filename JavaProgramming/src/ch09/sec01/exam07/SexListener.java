package ch09.sec01.exam07;

public class SexListener implements CheckBox.CheckListener {
	@Override
	public void check() {
		if(CheckBox.index == "남자")
			System.out.println("남자를 체크했기 때문에 줄을 서야 합니다.");
		else
			System.out.println("여자를 체크했기 때문에 통과입니다.");
	}

}
