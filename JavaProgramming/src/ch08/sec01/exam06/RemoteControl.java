package ch08.sec01.exam06;

public interface RemoteControl {
	//상수
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	//추상 메소드(public abstract 생략)
	void turnOn();
	void turnOff();
	void setVolume(int volume);
//	void search(String url);

}
