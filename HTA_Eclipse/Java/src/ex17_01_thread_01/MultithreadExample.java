package ex17_01_thread_01;

/*
 * 알파벳과 숫자를 동시에 출력하는 멀티 스레드 프로그램
 * JVM 이 스레드에 할당하는 시간과 실행 순서는 하드웨어의 성능이나 시스템 환경에 따라 다르다. 
 * 그래서 실행 결과가 일정하지 않다.
 */
public class MultithreadExample {

	public static void main(String[] args) {

		Thread thread = new DigitThread(); // 스레드 생성

		// thread 를 실행
		thread.start();
		/*
		 * - start() 설명 Cause this thread to begin execution; 
		 * the Java Virtual Machine calls the run method of this thread. 
		 * 자바의 JVM 이 해당 스레드를 호출하는 run()메서드를 실행하는 것이지 
		 * 컴파일 단계에서 run()하지 않는다 
		 * start() 메서드를 통해 가상머신이 해당 스레드를 호출하는 run() 메서드를 실행시키게 한다는 점이 중요하다. 
		 * start() 메서드는 java.lang.Thread 클래스의 메서드이다. 
		 * 새로 생성한 Thread 를 start하면 Runnable 상태가 된다.
		 * thread.run() 이렇게 사용하지 않는다.
		 */
		
		for (char ch = 'A' ; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
		System.out.println("스레드 이름 : " + Thread.currentThread().getName());
	}
}
/* 출력 결과
 * 1
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ스레드 이름 : main
 * 0123456789스레드 이름2 : Thread-0 <- 기본 스레드 이름
 * 
 * 2
 * ABCD012345678EFG9HIJKLMNOPQ스레드 이름2 : Thread-0
 * RSTUVWXYZ스레드 이름 : main
 * 
 * 3
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ01234스레드 이름 : main
 * 56789스레드 이름2 : Thread-0
 * 
 * 돌릴 때마다 작업순서가 뒤죽박죽이다.
 * 하지만 어쨋든 작업이 끝까지 수행된다는 점이 중요하다.
 */
