package ex13_2;

public class ObjectExample2 {

	public static void main(String args[]) {
		GoodsStock2 obj = new GoodsStock2("73527", 200);
		// 문자열과 GoodsStock 객체 변수를 + 연산자로 연결하면
		// 객체의 toString 메서드가 자동으로 호출된 후 문자열과 연결된다.
		// String str = "재고 정보 = " + obj.toString();
		String str = "재고 정보 = " + obj;
		System.out.println(str);
	}
}
