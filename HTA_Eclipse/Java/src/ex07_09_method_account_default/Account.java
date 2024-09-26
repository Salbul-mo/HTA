package ex07_09_method_account_default;

public class Account {

	String accountNo;
	String ownerName;
	int balance;

	Account(String accountNo, String ownerName, int balance) { //생성자
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	void deposit(int amount) { // 예금
		balance += amount;
	}

	int withdraw(int amount) { // 출금
		if (amount > balance) {
			return 0;
		}
		balance -= amount;
		return amount;
	}
}
