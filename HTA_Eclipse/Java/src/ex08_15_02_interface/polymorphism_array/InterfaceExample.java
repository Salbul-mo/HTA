package ex08_15_02_interface.polymorphism_array;

public class InterfaceExample {

	public static void main(String[] args) {
		Lendable arr[] = new Lendable[3];
		//Lendable 인터페이스를 타입으로하는 배열 생성
		
		arr[0] = new SeparateVolume("883ㅇ", "푸코의 진자", "에코");
		arr[1] = new SeparateVolume("ㅇ609.2", "서양미술사", "곰브리치");
		arr[2] = new AppCDInfo("02-17", "마이크로서비스를 위한 자바 프로그래밍", "유시진");
		//배열에 여러 타입의 객체 참조값 저장
		
		checkOutAll(arr, "홍길동", "2024-07-31");

	}

	// 인터페이스 Lendable[] 타입의 참조값을 매개참조변수로 하는 static 메서드 checkOutAll()
	static void checkOutAll(Lendable[] arr, String borrower, String date) {
		for (Lendable ar : arr)
			ar.checkOut(borrower, date);

	}
}
