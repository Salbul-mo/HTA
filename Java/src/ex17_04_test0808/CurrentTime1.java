package ex17_04_test0808;

import java.text.SimpleDateFormat;

class CurrentTime1 extends Thread {
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("1번 yyyy년MM월dd일 E요일 HH시mm분ss초");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			long times = System.currentTimeMillis();
			String str = sdf.format(times);
			System.out.println(str);
		}
	}
}
