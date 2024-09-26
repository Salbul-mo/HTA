package ex08_04_overriding;
/*
 * 메서드 오버라이딩(슈퍼클래스에 정의된 메서드를 서브 클래스에서 재정의하는 것) 조건
 * 1. 상속 관계 일것
 * 2. 부모 클래스의 선언부와 일치(리턴값 타입, 메서드 이름, 매개변수 목록)
 * 3. 접근 제어자의 범위는 같거나 넓어야 한다. -private < default < protected < public
 */

public class CreditLineAccount extends Account {
	int creditLine; // 마이너스 한도

	CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}

	//메서드 오버라이딩 - 인출하는 기능 다시 구현
	//(잔액 + 마이너스 한도) < 인출액 경우 "인출이 불가능합니다" 예외 발생시킨다.
	int withdraw(int amount) throws Exception { // 출금
		if (amount > balance + creditLine) {
			throw new Exception("인출이 불가합니다.");
		}
		balance -= amount;
		/*if (balance < 0) {
			int temp = balance;
			balance = 0;
			creditLine += temp;
		}*/
		return amount;
	}

}
