package ex17_04_test0808;

import java.text.SimpleDateFormat;

public class Ex_08_08_Main {
	public static void main(String[] args) {
		CurrentTime1 thread1 = new CurrentTime1(); // 스레드 클래스 상속
		CurrentTime2 time2 = new CurrentTime2(); // Runnable 인터페이스 구현 클래스
		Thread thread2 = new Thread(time2); // 구현 클래스 객체를 매개 변수로 스레드 생성
		Thread thread3 = new Thread(() -> { // 익명 클래스로 Runnable 구현한 객체 람다식 표현
			SimpleDateFormat sdf = new SimpleDateFormat("3번 yyyy년MM월dd일 E요일 HH시mm분ss초");
			while (true) {
				try {
					Thread.sleep(1010);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				long times = System.currentTimeMillis();
				String str = sdf.format(times);
				System.out.println(str);
			}
		});
		// 쓰레드 상속한 익명 클래스 만들기
		// Thread asd = new Thread(){
		// 구현할 메서드 코딩
		// };
		Thread asd = new Thread() {
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("4번 yyyy년MM월dd일 E요일 HH시mm분ss초");
				while (true) {
					try {
						Thread.sleep(1010);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					long times = System.currentTimeMillis();
					String str = sdf.format(times);
					System.out.println(str);
				}
			}
		};
		asd.start();
		thread3.start();
		thread2.start();
		thread1.start();
	}

}
