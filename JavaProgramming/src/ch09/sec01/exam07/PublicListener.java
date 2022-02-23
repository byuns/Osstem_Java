package ch09.sec01.exam07;

public class PublicListener implements CheckBox.CheckListener{
	@Override
	public void check() {
		if(CheckBox.index == "비공개")
			System.out.println("비공개를 체크했기 때문에 다른 사용자에게는 보이지 않습니다.");
		else
			System.out.println("공개를 체크했기 때문에 모든 사용자에게 공개됩니다.");
	}

}
