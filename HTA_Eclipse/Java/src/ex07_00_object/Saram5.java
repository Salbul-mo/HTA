package ex07_00_object;

public class Saram5 {
	// 필드 (멤버 변수)
	String name; // 이클립스에서 파란 색은 필드 변수
	double w;
	double ki;
	int age;

	// 생성자
	Saram5(String name2, double w2) {
		// 문자열을 받아서 필드변수 name에 대입하는 생성자이다.
		name = name2;
		w = w2;
		// 이클립스에서 파란 색은 필드 변수 / 갈색은 로컬 변수

	}
	// 생성자도 오버로딩 가능하다.
	Saram5(double w2 , String name2) {
		name = name2;
		w = w2;
	}

	// 메서드 .. 클래스의 필드를 그냥 사용할 수 있다.
	public void eat() {
		System.out.println(name + "이(가) 밥을 먹는다.");
	}

	// 메서드
	public void walk() {
		System.out.println(name + "이(가) 걷기전 몸무게는 " + w + "입니다.");
	}

	// 메서드
	public void sesu() {
		System.out.println(name + "이(가) 세수한다.");
	}

}
