package ex17_06_sharedarea_problem;

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

	}
}
