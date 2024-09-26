package ex13_8_clone_2_1_shallow;

public class ShallowCopy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 1), 2.0);
		Circle c2 = (Circle) c1.clone(); // 반환타입 Object이므로 명시적으로 다운 캐스팅 해준다.

		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);

		c1.p.x = 9;
		c1.p.y = 9;
		c1.r = 4;

		System.out.println("===== c1 변경 후 =====");
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		/*
		 * c1 = [p=(1, 1), r=2.0] 
		 * c2 = [p=(1, 1), r=2.0]
		 * ===== c1 변경 후 ===== 
		 * c1 = [p=(9, 9), r=4.0] 
		 * c2 = [p=(9, 9), r=2.0]
		 * 
		 * clone 된 c2 가 참조형 필드 Point p 가 c1의 p와 같으므로 (인스턴스 변수의 값만을 복제하므로)
		 * c1의 p 가 변경되면
		 * c2의 p 도 같이 변경된다.
		 * => 따라서 복제할 때 참조형 필드의 객체도 같이 복제해서 별도로 생성해 주어야 한다.
		 */

	}
}
