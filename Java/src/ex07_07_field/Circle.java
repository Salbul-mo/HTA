package ex07_07_field;

public class Circle {

	double radius;
	
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
		double area = (double) 3.14 * this.radius * this.radius;
		return area;
	}
}

