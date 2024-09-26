package ex17_02_thread_sleep;

/*
 *  -java.lang.Thread 클래스와 이 클래스의 서브 클래스를 Thread 클래스라고 한다.
 *  -스레드가 할 일을 run()  메서드 안에 작성해야 한다.
 *  -public void run() 형식으로 작성해야 한다. 
 */
public class DigitThread extends Thread {
	// 오버라이딩 - 오버라이딩 안해도 에러는 없다.
	// start()메서드로 실행된다.
	public void run() {
		for (int cnt = 0; cnt < 26; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1001); // Thread.sleep()은 실행되고 있는
				// 현재 스레드를 정지시키는 static 메서드이므로
				// 멈출 스레드의 run() 메서드 안에 sleep을 해주어야 한다.
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
