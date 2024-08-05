package ex09_03_upcasting;

public class CheckingAccount extends Account {
	//직불카드 통장
	String cardNo;

	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}

	int pay(String cardNo, int amount) throws Exception {
		if (!cardNo.equals(this.cardNo) || (balance < amount)) {
			throw new Exception("지불이 불가능합니다.");
		}
		return withdraw(amount);
	}

}
