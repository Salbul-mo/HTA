package ex17_09_syn_solution;

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
	
	
}
