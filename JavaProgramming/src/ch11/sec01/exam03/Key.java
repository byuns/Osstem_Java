package ch11.sec01.exam03;

public class Key {
	private int num;
	private String name;
	
	public Key(int num,String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return this.num;
	}
	@Override
	public boolean equals(Object object) {
		Key key = (Key)object;
		if(num == key.num && name.equals(key.name)) {
			return true;
		}
		return false;
	}
	
	

}
