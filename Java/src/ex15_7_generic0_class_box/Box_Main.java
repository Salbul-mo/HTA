package ex15_7_generic0_class_box;

public class Box_Main {

	public static void main(String[] args) {
		Box box1 = new Box(); // Object 타입 클래스 객체 생성
		Box box2 = new Box();
		box1.set("홍길동"); // String -> Object 로 업 캐스팅
		box2.set(100); // int -> Integer 오토 박싱. Integer -> Object 로 업캐스팅

		System.out.println((String) box1.get());
		// Object -> String 다운 캐스팅. String.toString()
		System.out.println((Integer) box2.get());
		// Object -> Integer로 다운 캐스팅.
		// Integer.toString()

	}

}
