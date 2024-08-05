package ex07_08_final_field;

public class Circle {

	double radius;
	
	final double PI = 3.14;  // 상수 모두 대문자. 단어 간 구분은 언더바 _
	
	Circle(double radius) {
		this.radius = radius;
		/*
		 * this 란 ?
		 * 자바는 객체를 참조할 수 있도록 this 키워드를 제공한다
		 * 참조변수로 인트턴스 자신의 주소가 저장되어 있다.
		 * 생성자와 모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재한다.
		 */
	}
	
	double getArea() {
		double area = PI * Math.pow(radius,2);
		return area;
	}
}

