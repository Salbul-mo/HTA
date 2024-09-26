package ex15_7_generic1_4_wild;

import java.util.*;

public class ArrayList_Generic2 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Child ch1 = new Child("손자1");
		Child ch2 = new Child("손자2");

		Parent p1 = new Parent("큰아버지");
		Parent p2 = new Parent("작은아버지");

		GrandParent gp = new GrandParent("할아버지");

		ArrayList obj = new ArrayList();
		// Raw 타입 ArrayList. 객체 타입을 모른다.
		obj.add(ch1); 
		obj.add(ch2); 
		obj.add(p1); 
		obj.add(p2); 
		obj.add(gp);

		print(obj);//객체 타입 모르는 ArrayList 매개변수로 메서드 호출
	}

//한개의 print()를 이용해서 출력하도록 합니다.
	public static void print(ArrayList<? super Child> obj) {
		// 매개변수로 받는 ArrayList 안의 객체는 모두 Child 이거나 Child의 슈퍼 클래스이다
		for (Object a : obj) { // 이 경우에는 일일이 업캐스팅했다가 다운 캐스팅해줘야하니 그냥
								//Object로 퉁친다.
			String str = a.toString();
			System.out.println(str);
		}
	}
}
