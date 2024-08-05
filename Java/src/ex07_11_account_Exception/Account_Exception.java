package ex07_11_account_Exception;

public class Account_Exception {

	String accountNo;
	String ownerName;
	int balance;

	Account_Exception(String accountNo, String ownerName, int balance) { //생성자
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	void deposit(int amount) { // 예금
		balance += amount;
	}

	int withdraw(int amount) throws Exception { // 출금
		if (amount > balance) {
			throw new Exception("잔액이 부족합니다.");
		}
		balance -= amount;
		return amount;
	}
	
}
