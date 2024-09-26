package ex09_03_upcasting;

public class BonusPointAccount extends Account {
	//보너스포인트 통장
	int bonusPoint;

	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	void deposit(int amount) {
		balance += amount;
		bonusPoint += (int) (amount * 0.001);
	}
}
