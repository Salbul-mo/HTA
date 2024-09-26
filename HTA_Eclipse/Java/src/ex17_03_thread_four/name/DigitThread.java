package ex17_03_thread_four.name;

//숫자 출력하는 스레드 클래스

public class DigitThread extends Thread {

	public void run() {
		for (int cnt = 0; cnt < 26; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1001);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("스레드 이름 (digit) : " + Thread.currentThread().getName());
	}

}
