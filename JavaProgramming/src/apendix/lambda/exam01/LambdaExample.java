package apendix.lambda.exam01;

public class LambdaExample {

	public static void action(Calculable calculable) {
		int x = 10;
		int y = 4;
		
		calculable.calculate(x, y);
	}
	
	public static void main(String[] args) {
		//익명 구현 객체를 매개값으로 제공
		action(new Calculable() {
			@Override
			public void calculate(int x, int y) {
				int result = x + y;
				System.out.println(result);
			}
		});
		
		//람다식을 매개값으로 제공
		action((x,y) ->{
			int result = x + y;
			System.out.println(result);
		});
		
		action((x,y)-> System.out.println(x-y));
		

	}

}
