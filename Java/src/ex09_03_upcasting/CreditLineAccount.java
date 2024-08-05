package ex09_03_upcasting;

public class CreditLineAccount extends Account {
	// 마이너스 통장
	int creditLine;

	CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}

	int withdraw(int amount) throws Exception {
		if (amount > balance + creditLine) {
			throw new Exception("인출이 불가합니다.");
		}
		balance -= amount;
		return amount;
	}

}
