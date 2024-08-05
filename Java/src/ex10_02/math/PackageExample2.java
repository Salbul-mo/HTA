package ex10_02.math;

import ex10_02.geometry.polygon.Rectangle; // Rectangle 클래스 import

public class PackageExample2 {

	public static void main(String args[]) {
		Rectangle obj = new Rectangle(2,3); 
		//컴파일 에러.The constructor Rectangle(int, int) is not visible
		//생성자가 default 접근 제어자라서 다른 패키지에서 접근할 수 없다.
		System.out.println("면적 = " +obj.getArea());
		//The method getArea() from the type Rectangle is not visible
		//getArea() 역시 default 접근 제어자라서 다른 패키지에서 접근할 수 없다.
	}
}
