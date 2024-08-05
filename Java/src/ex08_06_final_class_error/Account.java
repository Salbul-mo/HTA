package ex08_06_final_class;

//상속을 금지하는 final 키워드
public final class Account { 

	String accountNo; //계좌번호
	String ownerName; //예금주 이름
	int balance; 	  //잔액		

	Account(String accountNo, String ownerName, int balance) { // 생성자
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
