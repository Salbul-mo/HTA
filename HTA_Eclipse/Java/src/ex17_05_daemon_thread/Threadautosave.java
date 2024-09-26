package ex17_05_daemon_thread;

public class Threadautosave implements Runnable {
	static boolean autoSave = false;
	public void run() {
		while(true) { //무한 반복
			try {
				Thread.sleep(3*1000); //3초 마다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// autoSave의 값이 true이면 autoSave() 메서드 호출
			if (autoSave) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동 저장되었습니다.");
	}

}
