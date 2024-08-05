package ex07_09_method_account_default;

public class Account_Main {

	public static void main(String[] a) {
		
		Account account = new Account("111-222-33333333","홍길동",1000);
		print(account);
		
		account.deposit(1000);
		print(account);
		
		account.withdraw(500);
		print(account);
		
		
	}
	
	static void print(Account account) {
		System.out.println("계좌번호 : " +account.accountNo + "\n예금주 이름 : " + account.ownerName + "\n잔액 : " + account.balance);
		System.out.println();
	}
}
