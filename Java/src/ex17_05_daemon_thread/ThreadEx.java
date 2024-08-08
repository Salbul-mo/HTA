package ex17_05_daemon_thread;
/*
 * 데몬 스레드(daemon thread)는 일반 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다
 * 일반 스레드가 모두 종료되면 데몬 스레드는 강제적으로 자동 종료된다.
 * 데몬 스레드는 일반 스레드의 보조역앟ㄹ을 수행하므로 일반 스레드가 모두 종료되고 나면
 * 데몬 스레드의 존재의 의미가 없기 때문이다.
 * 이 점을 제외하고는 데몬 스레드와 일반 스레드는 다른게 없다.
 * 데몬 스레드의 예로는 가비지 컬렉터, 워드 프로세서의 자동 저장, 미디어 플레이어의 동영상 및 음악 재생등이 있다.
 * 이 기능들은 주 스레드 JVM, 워드프로세서, 미디어 플레이어가 종료되면 같이 종료된다.
 * 
 *  데몬 스레드는 무한 루프와 조건문을 사용하여 실행 후 대기하고 있다가 특정 조건이 만족되면
 *  실행되고 다시 대기하도록 작성한다.
 *  
 *  데몬 스레드 사용법
 *  스레드 생성 -> 반드시 setDaemon(true)메서드 호출 -> start()메서드 호출
 *  void setDaemon(boolean ) : true(데몬 스레드로 설정) , false(일반 스레드로 설정)
 */
public class ThreadEx {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Threadautosave());
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. 무한 반복 스레드라서
		
		t.start(); // 스레드 스타트. 
		//3초마다 메서드 호출하지만
		//autoSave가 false 라서 autoSave()메서드 호출하지 않음
		
		for (int i = 1; i <= 30; i++) {
			try {
				Thread.sleep(1000); // 1초 멈췄다가
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(i); // i 출력. 30까지 반복
			
			if(i == 5) { // i 가 5일 때
				Threadautosave.autoSave = true; // Threadautosave() 트리거 true로 바꿈.
			}
			//3초마다 autoSave()메서드 실행
		}
		System.out.println("프로그램을 종료합니다.");
	
	}

	
}
