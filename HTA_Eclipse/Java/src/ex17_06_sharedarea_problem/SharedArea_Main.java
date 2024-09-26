package ex17_06_sharedarea_problem;
public class SharedArea_Main {
	
	public static void main(String[] args) {
		SharedArea sa = new SharedArea();
		// 동일한 객체를 참조값으로 필드 초기화한 두 스레드 생성
		CalcThread thread1 = new CalcThread(sa);
		PrintThread thread2 = new PrintThread(sa);
		
		thread1.start();
		thread2.start();
		
	}

//CalcThread가 계산된 pi 값을 공유 영역에 쓰기도 전에 printThred가 작업을 마쳤다.
//공유 영역의 데이터 = 0.0
}