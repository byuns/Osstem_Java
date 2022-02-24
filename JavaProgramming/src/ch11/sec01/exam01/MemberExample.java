package ch11.sec01.exam01;

import java.util.*;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		}else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		//동등 비교를 해서 같으면 중복 저장하지 않는 경우
		HashSet<Member> hashset = new HashSet<>(); // 중복된 값을 저장하지 못한다. 순서가 없다. : 집합 특징
		hashset.add(obj1);
		hashset.add(obj2);
		System.out.println(hashset.size());

		
	}

}
