package ch07.sec03.verify;

public class PublicTransportExample {
	public static void run(PublicTransport pt) {
		pt.take();
		pt.runTime();
		pt.payment();
		pt.getName();
		pt.getTime();
		pt.getMoney();
		
		if(pt instanceof Bus) {
			Bus bus = (Bus)pt;
			bus.stand();
		}
		else if(pt instanceof Subway) {
			Subway subway = (Subway)pt;
			subway.sit();
		}
		else if(pt instanceof Texi) {
			Texi texi = (Texi)pt;
			texi.sitTogether();
		}
		pt.getOff();
		
	}

	public static void main(String[] args) {
		
		run(new Bus("가나다",3500,1));
		System.out.println("----------------");
		run(new Subway("라마바",5000,2));
		System.out.println("----------------");
		run(new Texi("사아자",6000,1));
		System.out.println("----------------");

	}

}
