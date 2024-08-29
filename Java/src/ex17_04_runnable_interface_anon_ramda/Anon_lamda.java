package ex17_04_runnable_interface_anon_ramda;

public class Anon_lamda {

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> { // 람다식?
			for (char ch = 'a'; ch < 'z'; ch++) {
				System.out.print(ch);
			}
		});

		thread1.start();

		char arr[] = { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };

		for (char ch : arr) {
			System.out.print(ch);
		}

	}
}
