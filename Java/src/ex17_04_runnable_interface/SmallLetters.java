package ex17_04_runnable_interface;
// Runnable 인터페이스를 이용하는 멀티스레드 구현
// 이 클래스는 Thread 클래스를 상속하지 않는다.
public class SmallLetters implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch);
		}
	}
}
