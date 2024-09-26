package ex17_10_syn_format2;

public class PrintThread extends Thread {
	private SharedArea sa;

	PrintThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {
		int cnt = 0;
		while (cnt < 3) {
			int sum = sa.getTotal();
			System.out.println("합계 금액 : " + sum);
			cnt++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
