package ex15_7_generic1_2_class_box;

public class Box_Main {

	public static void main(String[] args) {
		Box<Integer, String> box1 = new Box<Integer, String>();
		Box<Integer, String> box2 = new Box<>(); // 자바 7버전부터 생성자 지네릭 타입 선언은 생략 가능
		// Key 로 Integer , Value 로 String 받는 클래스 Box 객체 생성

		box1.setKey(1);
		// key 초기화
		box1.setValue("홍길동");
		// Value 초기화

		box2.setKey(2);
		// key 초기화
		box2.setValue("이순신");
		// Value 초기화

		System.out.println(box1.toString());

		System.out.println(box2.toString());

	}

}
