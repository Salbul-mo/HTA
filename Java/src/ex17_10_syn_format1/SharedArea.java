package ex17_10_syn_format1;

public class SharedArea {

	private Account account1; // 회사
	private Account account2; // 직원
	
	SharedArea(Account account1, Account account2) {
		this.account1 = account1;
		this.account2 = account2;
				
	}
	public Account getAccount1() {
		return account1;
	}
	public void setAccount1(Account account1) {
		this.account1 = account1;
	}
	public Account getAccount2() {
		return account2;
	}
	public void setAccount2(Account account2) {
		this.account2 = account2;
	}
	
	void transfer() { // 계좌 이체를 한다.
		synchronized(this) { // 동기화할 객체가 자기 자신이다.
			account1.withdraw(1000000);
			account2.deposit(1000000);
		}
	}
	
	int getTotal() { // 합계를 구한다.
		synchronized(this) { // 동기화할 객체가 자기 자신이다.
			return account1.getBalance() + account2.getBalance();
		}
	}
	
}
