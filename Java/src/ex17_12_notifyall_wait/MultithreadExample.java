package ex17_12_notifyall_wait;
/*
 * notify() wait() 메서드
 * 
 * 스레드 사이에 신호를 직접 주고 받을 수 있다. 
 * 동기화된 스레드는 동기화 블럭에서 다른 스레드에게 제어권을 넘기지 못한다.
 * 이와 같이 동기화된 블럭에서 스레드간의 통신(제어권을 넘김)하기 위해서
 * wait() notify() notifyAll() 메서드를 사용해야 한다.
 * 이 메서드를 사용할 때는 synchronized 블럭에서만 의미가 있다.
 * notifyAll()은 모든 쓰레드에 보낸다.
 */
public class MultithreadExample {
	
	public static void main(String[] args) {
		SharedArea sa = new SharedArea();
		// 동일한 객체를 참조값으로 필드 초기화한 두 스레드 생성
		
		CalcThread thread1 = new CalcThread(sa);
		PrintThread thread2 = new PrintThread(sa);
		PrintThread_Simple thread3 = new PrintThread_Simple(sa);
		PrintThread_Luxury thread4 = new PrintThread_Luxury(sa);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}

}