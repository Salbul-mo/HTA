package ex07_08_private_field2;

import java.util.Scanner;

public class Circle_Main{

	public static void main(String[] a) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요>");
		//double radius = sc.nextDouble();
		Circle circle = new Circle(sc.nextDouble());
		print(circle);

		//circle.radius = 5.5;
		circle.setRadius(10.5);
		print(circle);
		sc.close();
	}

	public static void print(Circle circle) {
		
		System.out.println("원의 반지름 = " + circle.getRadius());
		System.out.println("원의 넓이 = " + circle.getArea());
		//ctrl 1 은 퀵 픽스 (rename)에 유용하다.
	}

}

