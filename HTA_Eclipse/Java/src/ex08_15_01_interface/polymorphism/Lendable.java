package ex08_15_01_interface.polymorphism;

public interface Lendable { // 인터페이스

	// 추상 메서드 대출한다.
	public abstract void checkOut(String borrower, String date);

	// 추상 메서드 반납한다.
	public abstract void checkIn();
}
