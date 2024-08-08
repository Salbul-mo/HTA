package ex17_07_sharedarea_solution;
public class SharedArea_Main {
	
	public static void main(String[] args) {
		SharedArea sa = new SharedArea();
		// 동일한 객체를 참조값으로 필드 초기화한 두 스레드 생성
		CalcThread thread1 = new CalcThread(sa);
		PrintThread thread2 = new PrintThread(sa);
		
		thread1.start();
		thread2.start();
		
	}

//공유 영역의 데이터 = 3.141592651589258
}