package ex07_18_singleton;

public class Singleton {

	private static Singleton singleton = new Singleton();
	// 자기 자신의 타입으로 private static 필드에 자기 자신을 객체 선언

	private Singleton() {} // 접근제어자 private 로 생성자 호출 차단

	public static Singleton getInstance() {
		// public 으로 외부에 공개하고. 자신의 객체를 참조하는 참조값을 리턴하는 창구 메서드
		System.out.println("여기는 getInstance입니다.");
		return singleton;
	}
}
