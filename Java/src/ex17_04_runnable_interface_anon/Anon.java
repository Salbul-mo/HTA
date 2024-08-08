package ex17_04_runnable_interface_anon;

public class Anon {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for (char ch = 'a'; ch < 'z'; ch++) {
					System.out.print(ch);
				}
			}
		});
		thread1.start();

		char arr[] = { 'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ' };

		for (char ch : arr) {
			System.out.print(ch);
		}

	}
}
