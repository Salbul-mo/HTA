package ex08_17_interface_exception;

public class InterfaceContantExample {

	public static void main(String[] args) {
		Lendable2 arr[] = new Lendable2[3];
		// Lendable 인터페이스를 타입으로하는 배열 생성

		SeparateVolume obj = new SeparateVolume("863ㅂ", "나무", "베르베르");
		arr[0] = new SeparateVolume("883ㅇ", "푸코의 진자", "에코");
		arr[1] = new SeparateVolume("ㅇ609.2", "서양미술사", "곰브리치");
		arr[2] = new AppCDInfo("02-17", "마이크로서비스를 위한 자바 프로그래밍", "유시진");
		// 배열에 여러 타입의 객체 참조값 저장

		printState(obj);
		try {
			obj.checkOut("수지", "2024-07-31"); // 해당 메서드가 예외를 던지게 되었으므로
												// try - catch 문으로 감싸주어야 한다.

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			obj.checkOut("박보검", "2024-07-31"); // 해당 메서드가 예외를 던지게 되었으므로
			// try - catch 문으로 감싸주어야 한다.

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		printState(obj);

	}

	static void checkOutAll(Lendable2[] arr, String borrower, String date) {
		try {
			for (Lendable2 ar : arr) {
				ar.checkOut(borrower, date);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void printState(Lendable2 obj) {
		obj.printState();
	}
}
