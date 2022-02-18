package ch07.sec01.exam01;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		System.out.println("모델 : " +dmbCellPhone.model);
		System.out.println("색상 ㅣ " + dmbCellPhone.color);
		
		System.out.println("채널 : " + dmbCellPhone.channel);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요.");
		dmbCellPhone.recieveVoice("안녕하세요! 저는 홍길동인데요.");
		dmbCellPhone.sendVoice("아! 예~ 반갑습니다.");
		dmbCellPhone.hangeUp();
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannel(12);
		dmbCellPhone.turnOffDmb();

	}

}
