package ex17_08_syn_problem;

public class PrintThread extends Thread {
	private SharedArea sa;

	PrintThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {
		int cnt = 0;
		while (cnt < 3) {
			int sum = sa.getAccount1().getBalance() + sa.getAccount2().getBalance();
			System.out.println("계좌 잔액 합계 : " + sum);

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			cnt++;
		}
	}

}
