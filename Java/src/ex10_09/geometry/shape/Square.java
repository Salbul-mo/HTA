package ex10_09.geometry.shape;

import ex10_09.geometry.common.Polygon;

public class Square extends Polygon { // protected는 같은 패키지 또는 상속관계에서만 접근할 수 있다.

	public Square(int x, int y, int sideLength) {
		super(4);				//슈퍼 클래스의 protected 생성자 호출
		super.setPoint(0, x, y);//슈퍼 클래스의 protected 메서드 호출
		super.setPoint(1, x + sideLength, y);
		super.setPoint(2, x + sideLength, y + sideLength);
		super.setPoint(3, x, y + sideLength);
	}

	public int getX(int index ) {
		
		return super.x[index];
	}

	public int getY(int index) {
		
		return super.y[index]; //슈퍼 클래스의 protected 필드 호출
	}
}
