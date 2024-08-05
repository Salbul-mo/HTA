package ex07_08_private_field2;

public class Circle {
	
	/*
	 * 객체 지향 프로그래밍의 주요 특징 중 하나인 캡슐화는 클래스 멤버를 클래스 내부에 감추는 것이다.
	 * 클래스 멤버를 외부에서 조작할 수 없도록 은닉하기 위해 private 를 사용한다
	 * 하지만 일부 멤버는 외부 클래스가 사용할 수 있도록 공개해야 한다.
	 * 예로 리모컨은 복잡한 내부 회로를 캡슐화해서 은폐하지만 전원버튼
	 * 음량 조절 버튼 등은 외부에 노출해서 사용할 수 있게 한다.
	 * 이처럼 클래스 내부에 은닉한 필드를 외부에서 사용할 수 있ㄷ록
	 * Getter 와 Setter를 제공한다.
	 * 일반적으로 Getter 는 get, Setter 는 set으로 시작하는 이름을 사용한다.
	 * radius 필드에 접근하기 위해 getRadius(), setRadius() 메서드를 사용한다.
	 */

	private double radius;
	// 접근 제어자 private 는 클래스 내부에서 접근 가능하다.
	final double PI = 3.14;  // 상수 모두 대문자. 단어 간 구분은 언더바 _
	
	Circle(double radius) {
		this.radius = radius;
	
	}
	
	public double getArea() {
		double area = PI * Math.pow(radius,2);
		return area;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}

