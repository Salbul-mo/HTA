package ex17_02_thread_sleep;

public class MultuthreadExample2 {
	public static void main(String[] args) {
		Thread thread = new DigitThread();
		thread.start();
		// 알파벳 출력
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch); // 출력하고
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
