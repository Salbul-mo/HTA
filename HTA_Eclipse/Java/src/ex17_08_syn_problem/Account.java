package ex17_08_syn_problem;

class Account {

	private String accountNo;
	private String ownerName;
	private int balance;

	Account(String accountNo, String ownerName, int balance) { //생성자
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 클래스 안에서 마우스 우클릭 -> Source -> Generate Getter Setter 로 한 번에 만들 수 있다.
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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	

}