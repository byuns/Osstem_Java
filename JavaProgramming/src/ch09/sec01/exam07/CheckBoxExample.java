package ch09.sec01.exam07;


public class CheckBoxExample {

	public static void main(String[] args) {
		
		CheckBox dbSex = new CheckBox("남자");
		dbSex.addCheckListener(new SexListener());
		dbSex.check(); // 남자를 체크했기 때문에 줄을 서야합니다.
		
		CheckBox dbPublic = new CheckBox("비공개");
		dbPublic.addCheckListener(new PublicListener());
		dbPublic.check(); // 비공개를 체크했기 때문에 다른 사용자에게는 보이지 않습니다.

	}

}
