package ex08_15_01_interface.polymorphism;

public class InterfaceExample {

	public static void main(String[] args) {
		Lendable arr0, arr1, arr2; // 인터페이스 Lendable 타입의 참조값null 생성
		// arr0 = new Lendable(); 오류 발생. 인터페이스의 객체를 만들 수 없다.
		arr0 = new SeparateVolume("883ㅇ", "푸코의 진자", "에코");
		//new 에 의해 생성된 SeparateVolume 인스턴스의 참조값을 인터페이스 타입 arr0에 대입.
		arr1 = new SeparateVolume("ㅇ609.2", "서양미술사", "곰브리치");
		//new 에 의해 생성된 SeparateVolume 인스턴스의 참조값을 인터페이스 타입 arr1에 대입.
		arr2 = new AppCDInfo("02-17", "마이크로서비스를 위한 자바 프로그래밍");
		//new 에 의해 생성된 AppCDInfo 인스턴스의 참조값을 인터페이스 타입 arr2에 대입.


		checkOut(arr0,"홍길동","2024-07-31");
		checkOut(arr1,"홍길동","2024-07-31");
		checkOut(arr2,"홍길동","2024-07-31");

	}
	
	//인터페이스 Lendable 타입의 참조값을 매개참조변수로 하는 static 메서드 checkOut() 
	static void checkOut(Lendable arr, String borrower, String date) {
		arr.checkOut(borrower,date); 
		//인터페이스의 참조값으로 구현 클래스의 인스턴스를 참조할 수 있다.
		//컴파일은 인터페이스의 추상메서드로 하지만 JVM에서 구동은 Overriding으로 구현된 메서드가 실행된다.
	}
}
