package ex10_09.main;

import ex10_09.geometry.shape.Square;

public class AccessControlExample1 {

	public static void main(String args[]) {

		Square obj = new Square(100, 200, 15);
		for (int i = 0; i < 4; i++) {
			System.out.printf("X[%d]=%d, Y[%d]=%d\n", i, obj.getX(i), i, obj.getY(i));
		}
		for (int i = 0; i < 4; i++) {
			System.out.printf("(%d, %d)\n", obj.getX(i), obj.getY(i));
		}
		
		//외부 패키지에서 Polygon 클래스의 protected void setPoint(int index, int x , int y)에 접근할 수 없다.
		//obj.setPoint(3,10,10); The method setPoint(int, int, int) from the type Polygon is not visible
	}

}
