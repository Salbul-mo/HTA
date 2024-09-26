package ex17_04_test0808;

import java.text.SimpleDateFormat;

class CurrentTime2 implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1007);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			long times = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("2번 yyyy년MM월dd일 E요일 HH시mm분ss초");
			String str = sdf.format(times);
			System.out.println(str);
		}

	}
}
