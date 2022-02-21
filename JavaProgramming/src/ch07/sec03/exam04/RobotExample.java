package ch07.sec03.exam04;

public class RobotExample {
	public static void use(Robot robot) {
		robot.powerOn();
		System.out.println("종류 : " + robot.getKind());
		System.out.println("회사 : " + robot.getCompany());
		System.out.println("주인 : " + robot.getOwner());
		robot.move();
		robot.work();
		
		if(robot instanceof ARobot) {
			ARobot r = (ARobot)robot;
			r.selectMenu();
			r.wash();
		}
		else if(robot instanceof BRobot) {
			BRobot r = (BRobot)robot;
			r.fire();
			r.shoot();
		}
		else if(robot instanceof CRobot) {
			CRobot r = (CRobot)robot;
			r.speak();
		}
		
		robot.powerOff();
	}

	public static void main(String[] args) {
		
		use(new ARobot("음식점"));
		System.out.println("------------");
		use(new BRobot("국방부"));
		System.out.println("------------");
		use(new CRobot("구청"));
		System.out.println("------------");

	}

}
