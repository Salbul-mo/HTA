package ex15_7_generic1_1_class_box;

public class Box_Main {

	public static void main(String[] args) {
		Box<Integer> box1 = new Box<Integer>(); // <Integer> 타입을 받는 box2 객체 생성
		Box<String> box2 = new Box<String>(); // <String> 타입을 받는 box1 객체 생성
		box1.set(1); // int -> Integer 오토 박싱.
		box2.set("사과"); // String

		System.out.println(box1.get());
		// Integer.toString()
		System.out.println(box2.get());
		// String.toString()

	}

}
