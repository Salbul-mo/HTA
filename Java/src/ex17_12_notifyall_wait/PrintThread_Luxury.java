package ex17_12_notifyall_wait;

//파이 출력하는 클래스
public class PrintThread_Luxury extends Thread {

	private SharedArea sa;

	PrintThread_Luxury(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {

		if (sa.isReady() != true) { // 파이가 계산 중인 경우
			try {
				synchronized (sa) {
					sa.wait(); // 다른 스레드로부터 신호를 기다린다.
								// 파이의 계산이 끝나면 다른 스레드에서 신호를 보낸다.
				}
			} catch (InterruptedException e) { // wait() 메서드가 발생시키는 예외 처리
				System.out.println(e.getMessage());
			}
		}
		System.out.println("*** π =  " + sa.getResult() + " ***");
	}
}
