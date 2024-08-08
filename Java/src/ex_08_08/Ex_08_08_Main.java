package ex_08_08;

import java.text.SimpleDateFormat;

public class Ex_08_08_Main {
	public static void main(String[] args) {
		CurrentTime1 thread1 = new CurrentTime1();
		CurrentTime2 time2 = new CurrentTime2();
		Thread thread2 = new Thread(time2);
		Thread thread3 = new Thread(()-> {
			while (true) {
				try {
					Thread.sleep(1010);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				long times = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("3번 yyyy년MM월dd일 E요일 HH시mm분ss초");
				String str = sdf.format(times);
				System.out.println(str);
			}
		});

		thread3.start();
		thread2.start();
		thread1.start();
	}

}
