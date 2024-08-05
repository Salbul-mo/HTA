package ex07_08_private_field;

import java.util.Scanner;

public class Circle_Main_error {

	public static void main(String[] a) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름을 입력하세요>");
		//double radius = sc.nextDouble();
		Circle circle = new Circle(sc.nextDouble());
		print(circle);

		//circle.radius = 5.5;
		//print(circle);
		sc.close();
	}

	public static void print(Circle circle) {
		System.out.println("원의 반지름 = " + circle.radius);
		//Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		//The field Circle.radius is not visible
		//캡슐화. 정보 은닉이다.
		System.out.println("원의 넓이 = " + circle.getArea());
	}

}

