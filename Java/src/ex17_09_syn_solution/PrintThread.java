package ex17_09_syn_solution;

public class PrintThread extends Thread {
	private SharedArea sa;

	PrintThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {
		int cnt = 0;
		while (cnt < 3) {
			synchronized (sa) { // 동기화 시작
				int sum = sa.getAccount1().getBalance() + sa.getAccount2().getBalance();
				System.out.println("계좌 잔액 합계 : " + sum);
			} // 동기화 끝
			cnt++;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}