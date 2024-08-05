package ex08_05_super_method;

public class BonusPointAccount_Main {

	public static void main(String[] args) {
		
		BonusPointAccount ba = new BonusPointAccount("111-222-3333", "홍길동", 0, 0);
		
		ba.deposit(1000);
		
		System.out.println("잔액:" +ba.balance);
		System.out.println("누적 포인트:" +ba.bonusPoint);
	}
}
