package ex07_00_object;

public class Saram2 {
	// 필드 (멤버 변수)
	String name;
	double w;
	double ki;
	int age;

	// 생성자
	Saram2() {

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
 