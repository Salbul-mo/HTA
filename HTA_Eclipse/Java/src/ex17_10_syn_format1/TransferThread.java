package ex17_10_syn_format1;

public class TransferThread extends Thread {

	private SharedArea sa;

	TransferThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {
		int cnt = 0;
		while (cnt < 12) {
			sa.transfer();
			cnt++;
		}
	}
}
