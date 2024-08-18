package ex17_09_syn_solution;

public class TransferThread extends Thread {

	private SharedArea sa;

	TransferThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {
		int cnt = 0;
		while (cnt < 12) {
			synchronized (sa) { // synchronized(동기화할 객체) { 동기화 시작
				sa.getAccount1().withdraw(1000000);
				System.out.print("회사 계좌: 100만원 인출, ");
				sa.getAccount2().deposit(1000000);
				System.out.println("직원 계좌: 100만원 입금");
			} // 동기화 끝
			cnt++;
		}
	}

}