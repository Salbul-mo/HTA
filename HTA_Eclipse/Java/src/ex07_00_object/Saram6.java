package ex07_00_object;

public class Saram6 {
	// 필드 (멤버 변수)
	String name; // 이클립스에서 파란 색은 필드 변수
	double w;
	double ki;
	int age;

	// 생성자
	Saram6(String name, double w) {
		// 문자열을 받아서 필드변수 name에 대입하는 생성자이다.
		this.name = name;
		this.w = w;
		// 이클립스에서 파란 색은 필드 변수 / 갈색은 로컬 변수

	}
	// 생성자도 오버로딩 가능하다.
	Saram6(double w , String name) {
		this.name = name;
		this.w = w;
	}
	
	Saram6(String name , double w , double ki , int age) {
		this.name = name;
		this.w = w;
		this.ki = ki;
		this.age = age;
	}
	
	/*
	 * this 란? 
	 * 자바는 객체를 참조할 수 있도록 this 키워드를 제공한다.
	 * 참조변수로 인스턴스 자신의 주소가 저장되어 있다.
	 * 생성자와 모든 인스턴스 메서드에 지역변수로 숨겨친 채 존재한다.
	 */

	// 메서드 .. 클래스의 필드를 그냥 사용할 수 있다.
	public void eat() {
		System.out.println(this.name + "이(가) 밥을 먹는다.");
	}

	// 메서드
	public void walk() {
		System.out.println(this.name + "이(가) 걷기전 몸무게는 " + w + "입니다.");
	}

	// 메서드
	public void sesu() {
		System.out.println(this.name + "이(가) 세수한다.");
	}

}
