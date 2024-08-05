package ex08_04_overriding;

public class InheritanceExample {

	public static void main(String[] args) {

		String accountNo = "111-22-3333333";
		String ownerName = "홍길동";
		String cardNo = "5555-6666-7777-8888";

		CheckingAccount obj = new CheckingAccount(accountNo, ownerName, 0, cardNo);
		//CheckingAccount obj = new CheckingAccount(); 오류난다.
		
		obj.deposit(1000000);

		try {
			int paidAmount = obj.pay("5555-6666-7777-8888", 47000);
			System.out.println("지불액 : " + paidAmount);
			System.out.println("잔액 : " + obj.balance);
		} catch (Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
	}

}
