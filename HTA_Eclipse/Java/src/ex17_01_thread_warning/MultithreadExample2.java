package ex17_01_thread_warning;

/*
 * 알파벳과 숫자를 동시에 출력하는 멀티 스레드 프로그램
 * JVM 이 스레드에 할당하는 시간과 실행 순서는 하드웨어의 성능이나 시스템 환경에 따라 다르다. 
 * 그래서 실행 결과가 일정하지 않다.
 */
public class MultithreadExample2 {

	public static void main(String[] args) {

		Thread thread = new DigitThread(); // 스레드 생성

		thread.start();
		thread.start();
		/*
		 * 하나의 스레드에 대해 두번 start()메서드를 호출하면 java.lang.IllegalThreadStateException 에러
		 * 발생한다.
		 */
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
		System.out.println("스레드 이름 : " + Thread.currentThread().getName());
	}
	/*           처음 start로 호출된건 잘 돌아갔다.
	 * 0123456789Exception in thread "main" java.lang.IllegalThreadStateException
	 * 스레드 이름2 : Thread-0 
	 * at java.base/java.lang.Thread.start(Thread.java:793)
	 * at ex17_01_Thread.warning.MultithreadExample2.main(MultithreadExample2.java:17)
	 */
}
