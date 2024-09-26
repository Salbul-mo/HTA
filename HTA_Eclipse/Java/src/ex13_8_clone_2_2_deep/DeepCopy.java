package ex13_8_clone_2_2_deep;

public class DeepCopy {

	public static void main(String[] args) {
		Circle3 c1 = new Circle3(new Point(1, 1), 2.0);
		Circle3 c2 = c1.clone(); // 공변 반환 타입이므로 따로 다운 캐스팅할 필요 없다.

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
		 * c2 = [p=(1, 1), r=2.0]
		 * 
		 */
	}
}
