package ex08_04_overriding;

public class OverridingExample {
	public static void main(String[] args) {

	CreditLineAccount obj =
			new CreditLineAccount("000-11-111111", "김선달", 100, 20000);
	try {
		int amount = obj.withdraw(500);
		System.out.println("인출액: " + amount);
		System.out.println("잔액: " + obj.balance);
		System.out.println("마이너스 한도: " + obj.creditLine);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	}
}
