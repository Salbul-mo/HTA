package ex07_07_field;

public class Circle_Main {

	public static void main(String[] a) {

		double radius = 3.5;
		Circle circle = new Circle(radius);
		print(circle);

		circle.radius = 5.5;
		print(circle);

	}

	public static void print(Circle circle) {
		System.out.println("원의 반지름 = " + circle.radius);
		System.out.println("원의 넓이 = " + circle.getArea());
	}

}
