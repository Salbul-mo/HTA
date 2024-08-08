package ex17_06_sharedarea_problem;
//파이 출력하는 클래스
public class PrintThread extends Thread {

	private SharedArea sa;

	PrintThread(SharedArea sa) {
		this.sa = sa;
	}

	public void run() {
		System.out.println("공유 영역의 데이터 = " + sa.getResult());
	}
}
