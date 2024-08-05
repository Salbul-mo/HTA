package ex08_15_02_interface.polymorphism_array;

public interface Lendable { // 대여 인터페이스

	// 추상 메서드 대출한다.
	public abstract void checkOut(String borrower, String date);

	// 추상 메서드 반납한다.
	public abstract void checkIn();
}
