package ex17_02_thread_sleep;

public class MultiThreadExample {

	public static void main(String[] args) {
		// 알파벳 출력
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch); // 출력하고
			try {
				Thread.sleep(1000);
				/*
				 * sleep(Millis)메서드 : 일정 시간이 경과되기를 기다리게하는 메서드 
				 * 주어진 시간 동안 스레드를 일시 정지 상태로 만든다.
				 *  주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다.
				 *   public static void sleep(Long millis) throws InterruptedException 
				 *  Causes the currently executing thread to sleep
				 * (temporarily cease execution) for the specified number of milliseconds,
				 * subject to the precision and accuracy of system timers and schedulers.
				 *  The thread does not lose ownership of any monitors.
				 */

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			} // catch 엔드
		} // for 엔드
	}// 메인 엔드

}// 클래스 엔드
