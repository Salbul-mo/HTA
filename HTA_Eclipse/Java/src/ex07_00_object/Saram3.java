package ex07_00_object;

public class Saram3 {
	// 필드 (멤버 변수)
	String name; // 이클립스에서 파란 색은 필드 변수
	double w;
	double ki;
	int age;

	// 생성자 
	Saram3(String name2) { 
	// 문자열을 받아서 필드변수 name에 대입하는 생성자이다.
		name = name2; 
	// 이클립스에서 파란 색은 필드 변수 / 갈색은 로컬 변수
		
	}

	// 메서드 .. 클래스의 필드를 그냥 사용할 수 있다.
	public void eat() {
		System.out.println(name+"이(가) 밥을 먹는다.");
	}

	// 메서드
	public void walk() {
		System.out.println(name+"이(가) 걷는다.");
	}

	// 메서드
	public void sesu() {
		System.out.println(name+"이(가) 세수한다.");
	}

}
 