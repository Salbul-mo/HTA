package ex10_02.geometry.polygon_public;

/* 
 * 클래스명 : Rectangle (public)
 * 
 */
public class Rectangle {

	public int width;
	public int height;

	public Rectangle(int width, int height) { // 클래스는 public 이지만 생성자는 default 이다.
		this.width = width;
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}
}
