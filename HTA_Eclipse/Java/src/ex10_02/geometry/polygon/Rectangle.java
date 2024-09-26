package ex10_02.geometry.polygon;

/* 
 * 클래스명 : Rectangle (public)
 * 
 */
public class Rectangle {

	int width;
	int height;

	Rectangle(int width, int height) { // 클래스는 public 이지만 생성자는 default 이다.
		this.width = width;
		this.height = height;
	}

	int getArea() {
		return width * height;
	}
}
