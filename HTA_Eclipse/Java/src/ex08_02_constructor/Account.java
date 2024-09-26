package ex08_02_constructor;
//모든 클래스이 조상은 Object 클래스이다
//다른 클래스로부터 상속 받지 않는 모든 클래스들은 자동적으로 Object 클래스를 상속한다.

public class Account { //컴파일러가 자동으로 extends Object 를 추가한다.

	String accountNo; //계좌번호
	String ownerName; //예금주 이름
	int balance; 	  //잔액		



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
