package ex17_01_thread_01;
/*
 *  -java.lang.Thread 클래스와 이 클래스의 서브 클래스를 Thread 클래스라고 한다.
 *  -스레드가 할 일을 run()  메서드 안에 작성해야 한다.
 *  -public void run() 형식으로 작성해야 한다. 
 */
public class DigitThread extends Thread {
	//오버라이딩 - 오버라이딩 안해도 에러는 없다.
	//start()메서드로 실행된다.
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
		}
		
		System.out.println("스레드 이름2 : " + Thread.currentThread().getName());
		// 해당 스레드의 객체를 얻는 법 - Thread.currentThread();
		//Returns a reference to the currently executing thread object.
		//thread클래스.getName() 스레드 이름을 얻는다.
	}

}
