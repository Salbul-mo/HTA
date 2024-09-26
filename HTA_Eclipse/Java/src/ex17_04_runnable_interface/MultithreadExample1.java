package ex17_04_runnable_interface;

public class MultithreadExample1 {

	public static void main(String[] args) {
		//Runnable 인터페이스를 구현하는 클래스의 객체를 생성해서 Thread 생성자의 파라미터로 사용한다.
		SmallLetters small = new SmallLetters(); //Runnable 구현한 객체 생성
		Thread thread = new Thread(small); // 객체를 매개 변수로 스레드 생성
		thread.start(); // 해당 스레드 시작

		char arr[] = { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };
		
		for (char ch : arr) {
			System.out.print(ch);
		}
	}
	//ㄱabcdefghㄴㄷㄹㅁㅂㅅㅇijklmnoㅈㅊㅋㅌㅍㅎpqrstuvwxyz
}
