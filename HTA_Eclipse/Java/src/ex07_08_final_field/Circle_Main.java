package ex07_08_final_field;

import java.util.Scanner;

public class Circle_Main {

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
		System.out.println("원의 넓이 = " + circle.getArea());
	}

}


