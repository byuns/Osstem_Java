package ch09.sec01.exam07;

public class CheckBox {
	
	CheckListener checkListener;
	static String index;
	
	CheckBox(String index){this.index = index;}
	
	void addCheckListener(CheckListener checkListener) {
		this.checkListener= checkListener;
	}
	
	void check() {
		checkListener.check();
	}
	
	static interface CheckListener{
		void check();
	}

}
