package ex17_12_notify_wait;

public class CalcThread extends Thread {

	private SharedArea sa;

	CalcThread(SharedArea sa) {
		this.sa = sa;
	}

	@Override
	public void run() {
		double total = 0.0;

		for (int cnt = 1; cnt < 1000000000; cnt += 2) {

			if (cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		}

		sa.setResult(total * 4);
		// 계산이 끝나고 sa 필드 초기화하면 대기 상태 표지를 true로 바꾼다.
		sa.setReady(true);
		
		synchronized(sa) {
			sa.notify();
		}
	}
}
