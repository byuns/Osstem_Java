package ch07.sec01.exam07.pack2;

import ch06.sec06.exam03.package1.*;

public class C{
	public void method() {
		A a = new A();
//		a.field = "value"; // 상속이 아니라 접근 불가
		a.method();
	}

}
