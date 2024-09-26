package ex08_05_super_method;

public class BonusPointAccount extends Account {

	int bonusPoint;

	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	void deposit(int amount) { // 예금
		balance += amount;
		bonusPoint += (int) (amount * 0.001); 
		// (amount / 1000) 으로 하면 몫이 0이 나오는 경우 아래가 전부 잘려서 포인트 누적이 안된다.
	}
}
