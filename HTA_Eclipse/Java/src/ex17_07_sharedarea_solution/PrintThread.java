package ex17_07_sharedarea_solution;

//파이 출력하는 클래스
public class PrintThread extends Thread {

	private SharedArea sa;

	PrintThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {

		while (sa.isReady() != true) { //대기 표지값이 false일 동안 무한반복하면서 대기
			try {
				Thread.sleep(1); //1 밀리초 만큼 대기. (1/1000) 초
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("공유 영역의 데이터 = " + sa.getResult());
	}
}
