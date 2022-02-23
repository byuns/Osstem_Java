package ch09.sec01.exam07;

public class CheckBox {
	
	private CheckListener checkListener;
	public static String index;
	
	CheckBox(String index){this.index = index;}
	
	public void addCheckListener(CheckListener checkListener) {
		this.checkListener= checkListener;
	}
	
	public void check() {
		checkListener.check();
	}
	
	public static interface CheckListener{
		void check();
	}

}
