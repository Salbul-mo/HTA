package personal;

public class CustomException_jungseok {
	
	public static void main(String[] args) {
		try {
			startInstall();    //프로그램 설치할 준비
			copyFiles();      //파일 복사
		} catch (SpaceException e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다.");
		} catch (MemoryException me) {
			System.out.println("에러 메시지 : " + me.getMessage());
			me.printStackTrace();
			System.gc();       //Garbage Collection을 수행하여 메모리를 늘려준다.
			System.out.println("다시 설치를 시도하세요.");
		} finally {
			deleteTempFiles();              // 프로그램 설치에 사용된 임시파일들을 삭제
		}  //try 끝
	}
	
	private static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace())       // 충분한 설치 공간이 없으면....
			throw new SpaceException("설치할 공간이 부족합니다.");
		if (!enoughMemory())      // 충분한 메모리가 없으면....
			throw new MemoryException("메모리가 부족합니다.");
	} //startInstall 메서드 끝
	
	private static void copyFiles() { /*파일들을 복사하는 코드*/}
	private static void deleteTempFiles() { /*임시 파일들을 삭제하는 코드 */ }
	
	private static boolean enoughSpace() {
		// 설치하는데 필요한 공간이 있는지 확인하는 코드
		return false;
	}
	
	private static boolean enoughMemory() {
		// 설치하는데 필요한 메모리 공간이 있는지 확인하는 코드
		return true;
	}
	
} // ExceptionTest 클래스의 끝


class MemoryException extend Exception {
	MemoryException(String msg) {
		super(msg); // Exception 클래스의  .getMessage를 구현하여 
					// "메모리가 부족합니다" 를 출력하게 커스텀 했다.
	}
}


class SpaceException extends Exception {
	spaceException(String msg) {
		super(msg); // Exception 클래스의  .getMessage를 구현하여 
	}				// "설치할 공간이 부족합니다" 를 출력하게 커스텀 했다.
}



