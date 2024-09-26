package ex08_08_abstract_class;

//abstract 추가. 추상 클래스. 인스턴스화 할 수 없다.(객체로 만들 수 없다.) 에러 발생

public abstract class Account { 

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
